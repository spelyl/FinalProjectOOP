package group5.webapp.FinalProjectOOP.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Bill")
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int total;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@ManyToOne
	@JoinColumn(name="user_id")
    private User user;

	public Bill() {}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}

	public void setId(int iD) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	};

}
