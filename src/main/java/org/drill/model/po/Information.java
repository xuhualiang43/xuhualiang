package org.drill.model.po;
// Generated 2016-10-14 14:27:28 by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Information generated by hbm2java
 */
@Entity
@Table(name = "information", catalog = "test1")
public class Information implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String information;

	public Information() {
	}

	public Information(String information) {
		this.information = information;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "information")
	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}