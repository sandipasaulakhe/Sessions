
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
    import java.sql.SQLException;

	public class ConnectDb{
		static Connection connection=null;
		static String databaseName="";
		static String url="jdbc:mysql://localhost:3306/"+databaseName;
		static String username="root";
		static String password="sandipasaulakhe";
		
		@SuppressWarnings("deprecation")
		public static void main(String args[]) throws InstantiationException,IllegalAccessException,ClassNotFoundException, SQLException
		
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=connection.prepareStatement("INSERT INTO restraunt(Rid(primary key),RName,Radd,Rphonenumber,Ropeningtime,Rclosingtime)value(7,'kkk','EWEDFG',9825125412,10am,10pm)");
		
			int status=ps.executeUpdate();
		
			if(status!=0)
			{
				System.out.println("database connected");
				System.out.println(" record was inserted");
			}
		}
		 public Order   findOrderByID(int id)
		    {
		        Iterator<Order> it = orderList.iterator();
		        Order           re = null;
		        boolean         found = false;
		        
		        if(id < 0){
		            return null;
		        }
		        
		        while (it.hasNext() && !found) {
		            re = it.next();  
		            if( re.getOrderID() == id)
		            {
		                found = true;
		            }
		        }
		        
		        if(found)
		            return re;
		        else        
		            return null;
		    }
		 public final static int EDIT_ITEM_NAME = 1;
	     public final static int EDIT_ITEM_PRICE = 2;
	     public final static int EDIT_ITEM_TYPE = 3;
	     
	     public void editMenuItemData(int id, String newName, double newPrice, byte menuType) throws DatabaseException
	     {
	         MenuItem rMenuItem = findMenuItemByID(id);
	         rMenuItem.setName(newName);
	         rMenuItem.setPrice(newPrice);
	         rMenuItem.setType(menuType);
	         
	        /*try
	        {
	            updateMenuFile();
	        }
	        catch(DatabaseException dbe)
	        {
	            throw dbe;
	        }*/
	     }
	     
	     public void editMenuItemData(MenuItem rMenuItem, int which, String newData) throws DatabaseException
	     {
	         try
	         {
	             switch(which)
	             {
	                 case EDIT_ITEM_NAME:
	                    rMenuItem.setName(newData);
	                    break;
	                 case EDIT_ITEM_PRICE:
	                    double newPrice = Double.parseDouble(newData);
	                    if(newPrice < 0)
	                        throw new DatabaseException("Price must be positive number");
	                    else
	                        rMenuItem.setPrice(newPrice);
	                    break;
	                 case EDIT_ITEM_TYPE:
	                    byte newType = Byte.parseByte(newData);
	                    if(newType < MenuItem.MAIN || MenuItem.DESSERT < newType)
	                        throw new DatabaseException("Type must be between " + MenuItem.MAIN
	                                            + " and " + MenuItem.DESSERT + ")");
	                    else
	                        rMenuItem.setType(Byte.parseByte(newData));
	                    break;
	                 default:
	                    break;
	             }
	        }
	        catch(DatabaseException e)
	        {
	            throw e;
	        }
	        catch(Exception e)
	        {
	            throw new DatabaseException(e.getMessage());
	        }
	     }
	     
	     public void setMenuItemAsPromotionItem(MenuItem rMenuItem, double price)
	     {
	         rMenuItem.setState(MenuItem.PROMOTION_ITEM, price);
	     }
	     
	     public void resetMenuState(MenuItem rMenuItem)
	     {
	         rMenuItem.resetState();
	     }
	     
	     public void deleteMenuItem(MenuItem rMenuItem) throws DatabaseException
	     {
	         menuList.remove(rMenuItem);
	         /*try
	        {
	             updateMenuFile();
	        }
	        catch(DatabaseException dbe)
	        {
	            throw dbe;
	        }*/
	     }
	     
	     public void addMenuItem(int newID, String newName, double newPrice, byte newType) throws DatabaseException
	     {
	         MenuItem newMenuItem = new MenuItem(newID, newName,newPrice, newType);
	         menuList.add(newMenuItem);
	         Collections.sort(menuList, new MenuItemComparator());
	         /*try
	         {
	             updateMenuFile();
	        }
	        catch(DatabaseException dbe)
	        {
	            throw dbe;
	        }*/  
	     }
	     //---------------------------------------------------------------
	     // Order
	     //---------------------------------------------------------------
	     public int addOrder(int staffID, String staffName)
	     {
	         int newOrderID = ++todaysOrderCounts;
	         Order newOrder = new Order(staffID, staffName);
	         newOrder.setOrderID( newOrderID);
	         orderList.add(newOrder);
	         return newOrderID;
	     }
	     
	     public void addOrderItem(int orderID, MenuItem rItem, byte quantity)
	     {
	         Order rOrder = findOrderByID(orderID);
	         rOrder.addItem(rItem, quantity);
	     }
	     
	     public boolean deleteOrderItem(int orderID, int index)
	     {
	          Order rOrder = findOrderByID(orderID);
	          if(rOrder == null)
	            return false;
	          return rOrder.deleteItem(index);
	     }
	     
	     
	     //Cancel order: order data is not deleted from the database(Just put cancel flag on)
	     public boolean cancelOrder(int orderID)
	     {
	         Order rOrder = findOrderByID(orderID);
	        if(rOrder == null)
	            return false;
	         rOrder.setState(Order.ORDER_CANCELED);
	         return true;
	     }
	     //Delete order: order data is deleted from the database
	     public boolean deleteOrder(int orderID)
	     {
	         Order rOrder = findOrderByID(orderID);
	        if(rOrder == null)
	            return false;
	         orderList.remove(rOrder);
	         todaysOrderCounts--;
	         return true;
	     }
	     
	     public boolean closeOrder(int orderID)
	     {
	         Order rOrder = findOrderByID(orderID);
	        if(rOrder == null)
	            return false;
	         rOrder.setState(Order.ORDER_CLOSED);
	         return true;
	     }
	     
	     public void closeAllOrder()
	     {
	        Iterator<Order> it = orderList.iterator();
	        Order           re = null;
	        
	        while (it.hasNext()) {
	            re = it.next();  
	            if( re.getState() == 0)//neither closed and canceled
	            {
	                re.setState(Order.ORDER_CLOSED);
	            }
	        }
	     }
	     
	     public int getOrderState(int orderID)
	     {
	         Order  re = findOrderByID(orderID);
	         if(re == null)
	             return -1;
	         return re.getState();
	     }
	     
	     public double getOrderTotalCharge(int orderID)
	     {
	         Order  re = findOrderByID(orderID);
	         if(re == null)
	             return -1;
	         return re.getTotal();
	     }
	     
	     public boolean checkIfAllOrderClosed()
	     {
	        Iterator<Order> it = orderList.iterator();
	        Order           re = null;
	        
	        while (it.hasNext()) {
	            re = it.next();  
	            if( re.getState() == 0)//neither closed and canceled
	            {
	                return false;
	            }
	        }
	        return true;
	     }
	     
	     public boolean checkIfAllStaffCheckout()
	     {
	        Iterator<Staff> it = staffList.iterator();
	        Staff           re = null;
	        
	        while (it.hasNext()) {
	            re = it.next();  
	            if( re.getWorkState() == Staff.WORKSTATE_ACTIVE)
	            {
	                return false;
	            }
	        }
	        return true;
	     }
	     
	     public void forthClockOutAllStaff()
	     {
	         Iterator<Staff> it = staffList.iterator();
	         Staff           re = null;
	        
	         while (it.hasNext()) {
	            re = it.next();  
	            if( re.getWorkState() == Staff.WORKSTATE_ACTIVE)
	            {
	                re.clockOut();
	            }
	         }
	     }
	}


