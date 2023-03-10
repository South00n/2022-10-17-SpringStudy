<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 100%;
}
h1{
   text-align: center
}
.ddd:hover{
  cursor: pointer
}
</style>
</head>
<body>
	<div class="container-fluid">
      <div class="col-sm-6">
         <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		        <img :src="vo.poster" style="width:200px;height: 150px" v-on:click="foodDetail(vo.no)">
		        <div class="caption">
		          <p>{{vo.title}}</p>
		        </div>
		   </div>
		 </div>
		 
		 
      </div>
      
      
      <div class="col-sm-6" v-show="isShow">
        <table class="table">
        <tr>
            <td ><img :src="vo2.poster" style="width: 100%" class="img-rounded ddd"></td>
        </tr>
       </table>
	     <div style="height: 20px"></div>
	     <div class="row">
	      <div class="col-sm-8">
	        <table class="table">
	         <tr>
	           <td colspan="2">
	            <h3>{{vo2.title }}&nbsp;<span style="color:orange">{{vo2.score }}</span></h3>
	           </td>
	         </tr>
	         <tr>
	           <th width=10%>주소</th>
	           <td width=90%>{{vo2.addr }}
	             <br>
	             <sub>지번:{{vo2.addr2 }}</sub>
	           </td>
	         </tr>
	         <tr>
	           <th width=10%>전화</th>
	           <td width=90%>{{vo2.tel }}</td>
	         </tr>
	         <tr>
	           <th width=10%>음식종류</th>
	           <td width=90%>{{vo2.type }}</td>
	         </tr>
	         <tr>
	           <th width=10%>주차</th>
	           <td width=90%>{{vo2.parking }}</td>
	         </tr>
	         <tr>
	           <th width=10%>영업시간</th>
	           <td width=90%>{{vo2.time }}</td>
	         </tr>
	         </table>
	      </div>
	    </div>
     </div>
     
     <script>
     new Vue({
    	 el:'.container-fluid',
    	 data:{
    		 food_list:[],
    		 vo2:{},
    		 isShow:false
    	 },
    	 // http://localhost/web/food/category_vue.do?no=1
    	 mounted:function(){
    		 let _this=this
    		 axios.get('http://localhost:8080/web/jeju/list_vue.do',{
    			 
    		 // then => success:function(response)
    		 }).then(function(response){
    			 // response=>json
    			 console.log(response.data)
    			 _this.food_list=response.data;
    		 })
    	 },
    	 methods:{
    		 foodDetail:function(no){
    			 this.isShow=true
    			 let _this=this
        		 axios.get('http://localhost:8080/web/jeju/detail_vue.do',{
        			 params:{
        				 no:no
        			 }
        		 // then => success:function(response)
        		 }).then(function(response){
        			 // response=>json
        			 console.log(response.data)
        			 _this.vo2=response.data;
        		 })
    		 }
    		 
    	 }
     })
    </script>
</body>
</html>