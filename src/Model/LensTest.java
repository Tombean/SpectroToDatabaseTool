package Model;

public class LensTest {

	private int productId;
	private int sampleId;
	private double nm470;
	private double nm590;
	private double photopic;
	private double ratioB;
	private double sum;
	private double t1_2;
	private double t3_4;
	private double t7_8;
	private double t15_16;
	private double ax;
	private double bx;
	private boolean fullData;
	
	
	public LensTest(){
		
		this.productId = 0;
		this.sampleId = 0;
		this.nm470 = 0.0;
		this.nm590 = 0.0;
		this.photopic = 0.0;
		this.ratioB = 0.0;
		this.sum = 0.0;
		this.t1_2 = 0.0;
		this.t3_4 = 0.0;
		this.t7_8 = 0.0;
		this.t15_16 = 0.0;
		this.ax = 0.0;
		this.bx = 0.0 ;		
		this.fullData = false;
		
	}
	
	public LensTest(int productId, int sampleId, double nm470, double nm590, double photopic, double ratioB, double sum,
			double t1_2, double t3_4, double t7_8, double t15_16, double ax, double bx,  boolean fullData) {

		this.productId = productId;
		this.sampleId = sampleId;
		this.nm470 = nm470;
		this.nm590 = nm590;
		this.photopic = photopic;
		if (ratioB == 0 && nm470 != 0){
			this.ratioB = this.nm590 / this.nm470;
		}else {
			this.ratioB = ratioB;
		}
		if (sum == 0 ){
			this.sum = this.nm470 + this.nm590;
		}else{
			this.sum = sum;
		}
		this.t1_2 = t1_2;
		this.t3_4 = t3_4;
		this.t7_8 = t7_8;
		this.t15_16 = t15_16;
		this.ax =  ax;
		this.bx = bx;
		this.fullData = true;
	}
	
	/** Constructor for the HunterLab's computer 
	 * 
	 * @param productId
	 * @param sampleId
	 * @param ax
	 * @param bx
	 */
	public LensTest(int productId, int sampleId, double ax, double bx) {

		this.productId = productId;
		this.sampleId = sampleId;
		this.ax =  ax;
		this.bx = bx;
		this.fullData = false;
		this.nm470 = 0.0;
		this.nm590 = 0.0;
		this.photopic = 0.0;
		this.ratioB = 0.0;
		this.sum = 0.0;
		this.t1_2 = 0.0;
		this.t3_4 = 0.0;
		this.t7_8 = 0.0;
		this.t15_16 = 0.0;
		this.ax = 0.0;
		this.bx = 0.0 ;	
	}
	
	
	public LensTest(int productId, double nm470, double nm590, double photopic, double ratioB, double sum,
			double t1_2, double t3_4, double t7_8, double t15_16) {

		this.productId = productId;
		this.sampleId = 0;
		this.nm470 = nm470;
		this.nm590 = nm590;
		this.photopic = photopic;
		if (ratioB == 0 && nm470 != 0){
			this.ratioB = this.nm590 / this.nm470;
		}else {
			this.ratioB = ratioB;
		}
		if (sum == 0 ){
			this.sum = this.nm470 + this.nm590;
		}else{
			this.sum = sum;
		}
		this.t1_2 = t1_2;
		this.t3_4 = t3_4;
		this.t7_8 = t7_8;
		this.t15_16 = t15_16;
		this.ax =  0.0;
		this.bx = 0.0;
		this.fullData = false;
	}
	
	public int getProductId() {
		return productId;
	}


	public int getSampleId() {
		return sampleId;
	}


	public double getNm470() {
		return nm470;
	}


	public double getNm590() {
		return nm590;
	}


	public double getPhotopic() {
		return photopic;
	}


	public double getRatioB() {
		return ratioB;
	}


	public double getSum() {
		return sum;
	}


	public double getT1_2() {
		return t1_2;
	}


	public double getT3_4() {
		return t3_4;
	}


	public double getT7_8() {
		return t7_8;
	}


	public double getT15_16() {
		return t15_16;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}


	public void setNm470(double nm470) {
		this.nm470 = nm470;
	}


	public void setNm590(double nm590) {
		this.nm590 = nm590;
	}


	public void setPhotopic(double photopic) {
		this.photopic = photopic;
	}


	public void setRatioB(double ratioB) {
		this.ratioB = ratioB;
	}


	public void setSum(double sum) {
		this.sum = sum;
	}


	public void setT1_2(double t1_2) {
		this.t1_2 = t1_2;
	}


	public void setT3_4(double t3_4) {
		this.t3_4 = t3_4;
	}


	public void setT7_8(double t7_8) {
		this.t7_8 = t7_8;
	}


	public void setT15_16(double t15_16) {
		this.t15_16 = t15_16;
	}
	
	public void setFullData(boolean fullData) {
		this.fullData = fullData;
	}

	public boolean isFullData() {
		return fullData;
	}


	public void setAx(double ax) {
		this.ax = ax;
	}

	public void setBx(double bx) {
		this.bx = bx;
	}

	
	public double getAx() {
		return ax;
	}

	public double getBx() {
		return bx;
	}
	
}
