package com.project.myapp.vo;

public class PagingVO {
	// ����¡
	private int onePageRecord = 5;// �� �������� ����� ���ڵ� ��
	private int pageNum = 1;// ���� ������
	private int totalRecord;// �� ���ڵ� ��
	private int totalPage;// �� ������ ��
	private int offsetIndex = 0;// ������
	private int onePageCount = 5; // �� ���� ǥ���� ������ ��
	private int startPage = 1;// ���� ������

	//�˻�
	private String searchKey;//select ��
	private String searchWord;//�˻���
	private String category;//ī�װ�
	private String categoryArr[];
	private String area;//��������
	

	// ����¡
	public int getOnePageRecord() {
		return onePageRecord;
	}

	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		// offset ��ġ ���
		offsetIndex = onePageRecord * (pageNum - 1);
		// ������ ��ȣ ���۰�
		startPage = ((pageNum - 1) / onePageCount * onePageCount) + 1;

	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;

		// �� ������ ��(���ڵ� ���� 26���� ������ ���� 6��)
		if (totalRecord % onePageRecord == 0) {// ������ ���ڵ� ���� ���
			totalPage = totalRecord / onePageRecord;
		} else {// ������ ���ڵ� �ִ� ���
			totalPage = totalRecord / onePageRecord + 1;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOffsetIndex() {
		return offsetIndex;
	}

	public void setOffsetIndex(int offsetIndex) {
		this.offsetIndex = offsetIndex;
	}

	public int getOnePageCount() {
		return onePageCount;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	// �˻�
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		setCategoryArr(category.split(","));
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String[] getCategoryArr() {
		return categoryArr;
	}

	public void setCategoryArr(String[] categoryArr) {
		this.categoryArr = categoryArr;
	}

}
