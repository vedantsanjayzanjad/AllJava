package com.yash.pms;

public class Product {

		int proId;
		private String proMfgDate;
		private String proName;
		private String proDescription;
		private double proPrice ;
		
		public Product()
		{
			
		}
		
		public int getProId() {
			return proId;
		}
		public void setProId(int proId) {
			this.proId = proId;
		}
		public String getProMfgDate() {
			return proMfgDate;
		}
		public void setProMfgDate(String proMfgDate) {
			this.proMfgDate = proMfgDate;
		}
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public String getProDescription() {
			return proDescription;
		}
		public void setProDescription(String proDescription) {
			this.proDescription = proDescription;
		}
		public double getProPrice() {
			return proPrice;
		}
		public void setProPrice(double proPrice) {
			this.proPrice = proPrice;
		}
		public Product(int proId, String proMfgDate, String proName, String proDescription, double proPrice) {
			super();
			this.proId = proId;
			this.proMfgDate = proMfgDate;
			this.proName = proName;
			this.proDescription = proDescription;
			this.proPrice = proPrice;
		}
		
		@Override
		public String toString() {
			return "Product [proId=" + proId + ", proMfgDate=" + proMfgDate + ", proName=" + proName
					+ ", proDescription=" + proDescription + ", proPrice=" + proPrice + "]";
		}
		
		
		
		
}
