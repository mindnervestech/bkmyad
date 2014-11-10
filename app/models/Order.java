package models;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;

@Entity
@Table(name="Orders")
public class Order {
	
	@Id
	@Column(length=50)
	public String orderId;
	
	public float total;
	
	public Date orderDate;
	
	public String email;
	
	public String cc_orderNo;
	
	public String cc_bid;
	
	public String cc_category;
	
	public String bank_name;
	public String bankMsg;
	
	//@Cascade(value={CascadeType.ALL})
	@OneToMany(cascade={CascadeType.ALL})
	public List<ComposedAdSave> composedAd;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ComposedAdSave> getComposedAd() {
		return composedAd;
	}

	public void setComposedAd(List<ComposedAdSave> composedAd) {
		this.composedAd = composedAd;
	}
	
	public static Order byId(String orderId) {
		System.out.println(orderId);
		return JPA.em().createQuery("from Order where orderId = ?1",Order.class)
				.setParameter(1, orderId).getSingleResult();
		
	}

	public String getCc_orderNo() {
		return cc_orderNo;
	}

	public void setCc_orderNo(String cc_orderNo) {
		this.cc_orderNo = cc_orderNo;
	}

	public String getCc_bid() {
		return cc_bid;
	}

	public void setCc_bid(String cc_bid) {
		this.cc_bid = cc_bid;
	}

	public String getCc_category() {
		return cc_category;
	}

	public void setCc_category(String cc_category) {
		this.cc_category = cc_category;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBankMsg() {
		return bankMsg;
	}

	public void setBankMsg(String bankMsg) {
		this.bankMsg = bankMsg;
	}

	public static Order getOrderStatus(String orderIdStatus) {
		try {
            Query q = JPA.em().createNativeQuery(
                    "SELECT cc_orderNo FROM Orders  where orderId = ?1");
     	         
            q.setParameter(1, orderIdStatus);
            return (Order)q.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		
		
	}
	
	  @Transactional
	    public static List<Order> getAllOrderList(String UserId) {
	    Query q = JPA.em().createQuery("Select a from Order a where a.email = ?1");
	    q.setParameter(1, UserId);
	    return (List<Order>) q.getResultList();
	    }

	   @Transactional
	    public static long getAllOrdersTotal(String OrderID,  int rowsPerPage) {
	    	long totalPages = 0, size;
	    	BigInteger sizebig;
	    	
	    	if(OrderID.trim().equals("")) {
	    		sizebig = (BigInteger)JPA.em().createNativeQuery("select count(*) from Orders   order by  orderDate  desc").getSingleResult();
	    	} else {
	    		Query query = JPA.em().createNativeQuery("select count(*)  from Orders where orderId like ?1 order by  orderDate  desc");
	    		query.setParameter(1, "%"+OrderID+"%");
	    		sizebig= (BigInteger) query.getSingleResult();
	    	}
	    	//cast to long
	    	size=sizebig.longValue();
	    	totalPages = size/rowsPerPage;
	    	if(size % rowsPerPage > 0) {
				totalPages++;
			}
	    	System.out.println("total pages ::"+totalPages);
	    	return totalPages;
	    }
		
		 @Transactional
		    public static List<Object[]> getAllOrdersOfUsers(String orderId, int currentPage, int rowsPerPage, long totalPages) {
		    	int  start=0;
		    	/*Query q;*/
		    	String sql="";
		    	if(orderId.trim().equals("")) {
		    		sql = "select * from Orders   order by  orderDate  desc";//
		    	} else {
		    		sql ="select * from Orders where orderId like ?1 order by  orderDate  desc ";
		    	}

	    		if(currentPage >= 1 && currentPage <= totalPages) {
					start = (currentPage*rowsPerPage)-rowsPerPage;
				}
				if(currentPage>totalPages && totalPages!=0) {
					currentPage--;
					start = (int) ((totalPages*rowsPerPage)-rowsPerPage); 
				}
		    	Query q = JPA.em().createNativeQuery(sql).setFirstResult(start).setMaxResults(rowsPerPage);
		    	if(!orderId.trim().equals("")) {
					q.setParameter(1, "%"+orderId+"%");
				}
				
				return (List<Object[]>)q.getResultList();
				
		    }
			 public static Order findById(String id) {
			    	Query query = JPA.em().createQuery("Select a from Order a where a.orderId = ?1");
					query.setParameter(1, id);
			    	return (Order) query.getSingleResult();
			    }
	  
}
