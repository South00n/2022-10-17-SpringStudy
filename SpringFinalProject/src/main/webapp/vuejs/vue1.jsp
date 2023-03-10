<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		1) Front-End / Back-End
		   ---------   --------
		   JavaScript   자바/스프링/데이터베이스/AI
		2) = 상태(데이터) 관리 : 속도 증가 (가상메모리 : 가상 돔) => StringBuffer / String (+)
		   = HTML (DOM : 트리형태로 저장) => 효율적으로 관리 (분할 : 템플릿) => 컴포넌트
		   = 컴포넌트 : 재사용
		   = Vue.component => $emit()
		     new Vue() => 처리 => $on(서버)
		3) Vue
		   ---
		   1. 디렉티브
		      v-for
		      v-if
		      v-if ~ v-else
		      v-model (양방향 통신)
		   2. Component
		      <template>
		      Vue.component('태그명', template:'HTMl')
		   3. 외부 데이터 읽기 : axios
		   4. Router : 화면 이동
		   -----------------------------------------
		   ** 5. vuex, vue3
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div id="app">
    <button>등록</button>
    <my-component></my-component>
  </div>
  <script>
    Vue.component('my-component', {
    	template:'<h1>Hello Vue-Component</h1>'
    })
    new Vue({
    	el:'#app'
    })
  </script>
</body>
</html>