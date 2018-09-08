/*!
 * report.html 页面脚本.
 * 
 * @since: 1.0.0 2017-10-26
 * @author Way Lau <https://waylau.com>
 */
"use strict";
//# sourceURL=report.js

// DOM 加载完再执行
$(function() {
	$("#selectCityCode").change(function(){
		var cityCode=$("#selectCityCode").val();  //获取Select选择的Value
		var url = '/report/cityCode/' + cityCode;
		window.location.href= url;
	});
});