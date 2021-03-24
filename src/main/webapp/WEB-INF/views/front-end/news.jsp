<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Paging -->
<%@ taglib prefix="tag" uri="/WEB-INF/taglib/pagingTagLibs.tld"%>
<%!
	public BigDecimal discount(BigDecimal gia, int giam) {
		 return gia.subtract(gia.multiply(new BigDecimal(giam).divide(new BigDecimal(100))));
	}
%>
<!DOCTYPE html>
<html>
<head>
	<title>Tin tức</title>
	<meta charset="utf-8">
	<jsp:include page="/WEB-INF/views/front-end/common/css.jsp"></jsp:include>
</head>
<body>
<div class="wapper">
	<div class="go-to-top"> <button id="go-to-top"><i class="fas fa-chevron-up"></i></button></div>
		<jsp:include page="/WEB-INF/views/front-end/common/header.jsp"></jsp:include>
		<div class="bg">
			<div class="content">
				</div> 
				<!-- end banner -->
				<div class="ctgr-content">
					<div class="ctgr-content-left col-xl-3.5">
						<div class="category">
							<div class="category-top">DANH MỤC SẢN PHẨM</div>
							<ul class="drop-menu">
								<c:forEach var = "category" items = "${categories }">
									<li ><a  href="${pageContext.request.contextPath}/category/${category.seo}">${category.name }</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="ctgr-content-right col-xl-9">
						<div class="ctgr-product">
							<div class="ctgr-product-top">
								<a href="${pageContext.request.contextPath}/news"><i class="fas fa-th"></i>Tin tức
								</a>
							</div>
							<div class="ctgr-product-main">
								<div class="body-main-product">
								<div style="margin: 20px">
								<ul class="listimg"
									style="outline: 0px; margin-bottom: 10px; color: rgb(51, 51, 51); font-family: helvatica,&amp; quot; Open Sans&amp;quot; , sans-serif; font-size: 14px;">
									<li
										style="font-size:15px; outline: 0px; list-style: none; display: inline-block; margin-bottom: 30px;"><a
										href="${pageContext.request.contextPath}/newsDetail"
										title="Những cách trị sẹo rỗ từ thiên nhiên an toàn"
										style="outline: 0px; color: rgb(51, 51, 51);"><img
											src="https://imua.com.vn/images/tt/Nhung-cach-tri-seo-ro-tu-thien-nhien-an-toan-.jpg"
											align="left"
											alt="nhung-cach-tri-seo-ro-tu-thien-nhien-an-toan"
											title="Những cách trị sẹo rỗ từ thiên nhiên an toàn"
											style="outline: 0px; border-width: 1px; border-style: solid; border-color: rgb(221, 221, 221); max-width: 100%; width: 140px; margin-right: 15px; box-shadow: rgb(102, 102, 102) 1px 1px 2px 0px; border-radius: 5px; padding: 5px;"><span
											style="outline: 0px; font-weight: 700;">Những cách trị
												sẹo rỗ từ thiên nhiên an toàn</span><br style="outline: 0px;">Sẹo
											rỗ luôn là nỗi ám ảnh của hầu hết chúng ta, chúng không chỉ
											khiến da tổn thương đau đớn mà còn khiến mất tự tin, khó sử
											dụng mỹ phẩm. Vậy làm sao để tìm được cách trị sẹo rỗ an
											toàn, hiệu quả bạn hãy cùng theo dõi qua bài viết sau nha:</a></li>
									<li
										style="outline: 0px; list-style: none; display: inline-block; margin-bottom: 30px;"><a
										href="https://imua.com.vn/tin-tuc/cach-tri-seo-lom-tren-mat-voi-vitamin-e-don-gian.html"
										title="Cách trị sẹo lõm trên mặt với vitamin E đơn giản"
										style="outline: 0px; color: rgb(51, 51, 51);"><img
											src="https://imua.com.vn/images/tt/Cach-tri-seo-lom-tren-mat-voi-vitamin-E-don-gian-.jpg"
											align="left"
											alt="cach-tri-seo-lom-tren-mat-voi-vitamin-e-don-gian"
											title="Cách trị sẹo lõm trên mặt với vitamin E đơn giản"
											style="outline: 0px; border-width: 1px; border-style: solid; border-color: rgb(221, 221, 221); max-width: 100%; width: 140px; margin-right: 15px; box-shadow: rgb(102, 102, 102) 1px 1px 2px 0px; border-radius: 5px; padding: 5px;"><span
											style="outline: 0px; font-weight: 700;">Cách trị sẹo
												lõm trên mặt với vitamin E đơn giản</span><br style="outline: 0px;">Cách
											trị sẹo lõm trên mặt từ vitamin E luôn là một trong những
											phương pháp trị sẹo được rất nhiều người tin dùng. Vậy dùng
											sao cho hiệu quả và an toàn, bạn hãy cùng theo dõi qua bài
											viết sau</a></li>
								</ul>
								</div>
								<%-- <div class="phantrang container col-xl-6" style="background: #ffffff;">
									<tag:paginate offset="${page.offset }"
										count="${page.count }" uri="${pageUrl}" />
								</div> --%>
							</div>
						</div>
						
					</div>
				</div>
			</div>
				<!-- end content -->
			<jsp:include page="/WEB-INF/views/front-end/common/footer.jsp"></jsp:include>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/front-end/common/js.jsp"></jsp:include>	
</body>
</html>



