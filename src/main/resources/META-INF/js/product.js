var Productjs = {
		
		/**
		 * https://www.w3schools.com/js/js_json_syntax.asp
		 */
		
		deleteProduct: function(idP) {
			var data = {};
			data["id"] = idP;
			
			
			$.ajax({
				url: "/delete-product-with-ajax",
				type: "post",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						location.reload();
						
					} else {
						alert('Xóa không thành công!');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
			    }
			});
		},
		deleteCategory: function(idP) {
			var data = {};
			data["id"] = idP;
			
			
			$.ajax({
				url: "/delete-category-with-ajax",
				type: "post",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						location.reload();
						
					} else {
						alert('Xóa không thành công!');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
			    }
			});
		},
		
		
}

