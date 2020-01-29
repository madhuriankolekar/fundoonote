package com.bridgelabz.fundoonotes.model;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.apache.catalina.User;
import org.hibernate.annotations.Type;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="note")
@Getter
@Setter
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="notes_id")
	private Integer id;
	@Column
	private String title;
	@Column
	private String description;
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isTrashed;
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPinned;
	@Column
	private String color;
	@Column
	private LocalDateTime remaindMe;
	@Column
	private LocalDateTime createdStamp;
	@Column
	private LocalDateTime updatedStamp;
///  @Column(name="user_id")
	///private List<User> userId1;
	@Column(name = "label_id")
	private Long labelId;
	@Column(name="user_id")
	private Integer userId;

	@JoinColumn(name="user_id")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="note_label",joinColumns = {@JoinColumn(name="notes_id")},inverseJoinColumns = {@JoinColumn(name="label_id")})
	private List<Label> labelList;
	public void setDescription(String description2) {
		// TODO Auto-generated method stub
		
	}
	public void setTitle(String title2) {
		// TODO Auto-generated method stub
		
	}
	public Object getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isTrashed() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setUpdatedStamp(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
	public void setTrashed(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setUserId(Long userId2) {
		// TODO Auto-generated method stub
		
	}

	
	}

/*
 * 
 @Column(name="user_id")
	private Long userId;
	
	@Column(name="label_id")
	private Long labelId;
	
	@JoinColumn(name="user_id")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="note_label",joinColumns = {@JoinColumn(name="note_id")},inverseJoinColumns = {@JoinColumn(name="label_id")})
	private List<Label> labelList;
}
 */
	


