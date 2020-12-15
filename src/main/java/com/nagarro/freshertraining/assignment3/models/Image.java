package com.nagarro.freshertraining.assignment3.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image_details")

public class Image {

	@Id
	@GeneratedValue
	@Column(name = "image_id")
	private int imageId;

	@Column(name = "image_name")
	private String imageName;

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "image", columnDefinition = "longblob")
	private byte[] image;

//	private String base64Image;

	@Column(name = "image_size")
	private double imageSize;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the imageId
	 */
	public int getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

//	@Transient
//	public String getBase64Image() {
//		base64Image = Base64.getEncoder().encodeToString(this.image);
//		return base64Image;
//	}
//
//	public void setBase64Image(String base64Image) {
//		this.base64Image = base64Image;
//	}
//		public String getImage() {
//		   return  Base64.getEncoder().encodeToString(this.image);
//		}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the imageSize
	 */
	public double getImageSize() {
		return imageSize;
	}

	/**
	 * @param imageSize the imageSize to set
	 */
	public void setImageSize(double imageSize) {
		this.imageSize = imageSize;
	}
}
