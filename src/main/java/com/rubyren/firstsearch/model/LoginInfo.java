package com.rubyren.firstsearch.model;

public enum LoginInfo {
	FJSFDX("福建师范大学", "100463166", "SWXNG4TXW"),
	//
	HNDX("湖南大学", "100224542", "VXE3XNEPA"),
	//
	HZKJDX("华中科技大学", "100224534", "BAG4XAYUA"),
	//
	NCDX("南昌大学", "100463168", "ARUMPAXD"),
	//
	SCDX("四川大学", "100224548", "KXN6XBJEA"),
	//
	TJCJDX("天津城建大学", "100463170", "PAX7PXECE"),
	//
	TJKJDX("天津科技大学", "100335056", "XVY9BXENA"),
	//
	TJSYDX("天津商业大学", "100269371", "FXXCK9TUA"),
	//
	TJWGYDX("天津外国语大学", "100269377", "VAN3XMBUA"),
	//
	XNCJDX("西南财经大学", "100224556", "DXVA9SXFA"),
	//
	CJDX("长江大学", "100461805", "KETCH2JXG"),
	//
	ZGRMDX("中国人民大学", "100224455", "BAH4XEACA"),
	//
	ZNDX("中南大学", "100224536", "EMPTY9RAA"),
	//
	NFKJDX("南方科技大学", "100449103", "TRY3XDEAX"),
	//
	HNSFDX("海南师范大学", "100395908", "AXXS%PASS"),
	//
	JXZYYDX("江西中医药大学", "100439403", "CXXVE.FRX"),
	//
	SZTSG("深圳图书馆", "100338111", "XEWD2PXRK"),
	//
	SDTSG("首都图书馆", "100415520", "GUN6FAXSF"),
	//
	JJTSG("晋江图书馆", "100452609", "GAGE$XXNK"),
	//
	DGLGXY("东莞理工学院", "100451444", "TAG3HXAGY"),
	//
	HBTSG("湖北省图书馆", "100462960", "ACXD%NXXN");
	private LoginInfo(String name, String auth, String password) {
		this.name = name;
		this.auth = auth;
		this.password = password;
	}

	private final String name;
	private final String auth;
	private final String password;

	public String getName() {
		return name;
	}

	public String getAuth() {
		return auth;
	}

	public String getPassword() {
		return password;
	}

}
