<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	  1. 생명주기
	  2. 디렉티브
	      v-if / v-else / v-for / v-show / v-hide / v-bind / v-model ... (제어문)
	  3. 외부데이터 읽어서 제어 : axios
	  4. 컴포넌트 제작 방법
	  ----- 이벤트 처리 v-on:click
	  5. 기타 속성
	  6. 라우터
	  7. 배포 .. (javascript를 따로 제작) => 웹스톰 (NodeJS)
	  -------------------------------------------------- vuejs / vuex / vue3 (React)
	  
	  ================> new Vue({})
	  생명주기 함수
	  beforeCreate() : 인스턴스 초기화전(생성전) => 이벤트 등록
	  created() : 객체 생성 => 메모리 할당
	  beforeMount() : 가상돔(임시 저장소) => HTML을 올리기 전상태
	  mounted() : HTML이 올라가서 브라우저에 출력 ===================> window.onload
	  beforeUpdate() : 수정 전상태
	  updated() : 수정 완료
	  beforeDestory() : 페이지 이동 전 상태
	  destoryed() : 종료
	  
	  ==================> state / props (변경이 안되는 변수) ==> 속성값
	                      ----- 유지변수 (변경이 가능)
	  new Vue({
	    el: ==> 제어하는 영역(CSS)
	    data: {
	    	멤버변수 => 종료시까지 유지하는 변수
	    }
	  })
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}
.row {
	margin: 0px auto;
	width: 800px;
}
h1 {
	text-align: center
}
</style>
</head>
<body>
	<div class="container">
		<h1>Vue 생명주기</h1>
		<div class="row">
		  <input type="text" size=30 class="input-sm" v-model="message"> 
		  <h3>{{message}}</h3>
		</div>
	</div>
	<script>
	new Vue({
		el:'.container',
		data:{
			message: 'Hello VueJS'
		},
		// 생명주기함수
		// 자동으로 호출되는 함수
		beforeCreate:function(){
			console.log("beforeCreate Call : 인스턴스 초기화전 : 이벤트 등록..")
			// componentWillCreate()
		},
		created:function(){
			console.log("created Call : 인스턴스 생성 완료 : 이벤트 등록..")
			// componentDidCreate()
		},
		beforeMount:function(){
			console.log("beforeMount Call : HTML을 저장할 가상 메모리 확인: 서버에서 데이터 읽기=변수")
			// componentWillCreate()
			
		},
		mounted:function(){
			console.log("beforeMount Call : HTML을 저장할 가상 메모리 저장 완료 : 실제돔 비교 => 브라우저에 출력")
			// 다른 라이브러리 연동 -> AJAX, JQUERY ... => $(fucntion(){{}})
		},
		beforeUpdate:function(){
			console.log("beforeUpdate Call : 수정 전 상태")
		},
		updated:function(){
			console.log("updated Call : 수정 완료 => mouned")
		},
		beforeDestroy:function(){
			console.log("beforeDestory Class: 메모리 해제 전 상태")
		},
		destroyed:function(){
			console.log("destroyed: 메모리 해제 상태")
			
		}
	})
	</script>

</body>
</html>