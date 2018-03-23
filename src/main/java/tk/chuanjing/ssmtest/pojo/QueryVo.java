package tk.chuanjing.ssmtest.pojo;

public class QueryVo {

	private String custName;
	private String custSource;
	private String custIndustory;
	private String custLevel;
	private Integer page = 1;
	private Integer start;
	private Integer size = 10;
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustory() {
		return custIndustory;
	}
	public void setCustIndustory(String custIndustory) {
		this.custIndustory = custIndustory;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	
	@Override
	public String toString() {
		return "QueryVo [custName=" + custName + ", custSource=" + custSource
				+ ", custIndustory=" + custIndustory + ", custLevel="
				+ custLevel + ", page=" + page + ", start=" + start + ", size="
				+ size + "]";
	}
}
