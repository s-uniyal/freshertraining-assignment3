/**
 * 
 */
package com.nagarro.freshertraining.assignment3.models;

import java.util.Collection;

import javax.persistence.CascadeType;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author shashankuniyal
 *
 */

@Entity
@Table(name = "user_details")

public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	@Column(name = "username", unique = true )
	private String username;

	@Column(name = "full_name")
	private String name;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password")
	private String password;
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Image> images;

	/**
	 * @return the images
	 */
	public Collection<Image> getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(Collection<Image> images) {
		this.images = images;
	}
}
