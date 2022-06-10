<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="webjars/jquery/1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#main">비트교육센터</a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="#">HOME</a></li>
    	<li><a href="#emp">EMP</a></li>
    	<li><a href="#addemp">ADD EMP</a></li>
    	<li><a href="#login">LOGIN</a></li>
    </ul>
  </div>
</nav>

<div id="main" class="container">
	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	  <p>...</p>
	</div>
</div>
<div id="emp"></div>
<div id="addemp" class="container">
	<h2>입력페이지</h2>
	<form class="form-horizontal">
         <div class="form-group">
            <label for="empno" class="col-sm-2 control-label">empno</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" id="empno" name="empno" placeholder="empno">
            </div>
         </div>
         <div class="form-group">
            <label for="ename" class="col-sm-2 control-label">ename</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" id="ename" name="ename" placeholder="ename">
            </div>
         </div>
         <div class="form-group">
            <label for="sal" class="col-sm-2 control-label">sal</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" id="sal" name="sal" placeholder="sal">
            </div>
         </div>
         <div class="form-group">
            <label for="job" class="col-sm-2 control-label">job</label>
            <div class="col-sm-10">
               <input type="text" class="form-control" id="job" name="job" placeholder="job">
            </div>
         </div>
         <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
               <button type="submit" class="btn btn-primary">입력</button>
               <button type="reset" class="btn btn-default">취소</button>
               <button type="button" class="btn btn-default">뒤로</button>
            </div>
         </div>
      </form>
</div>

<script type="text/javascript">
$('#main,#emp,#addemp').css('padding-top', $('nav').height());
$('#main,#addemp').height($(document).height());

$(document).on('click', '#emp button', function(e){
	var empno = $(e.target).attr('data-empno');
	$.getJSON('api/emp/'+empno, function(data){
		var form = document.querySelector('#myModal form');
		var idx = data.empno;
		form.empno.value=data.empno;
		form.ename.value=data.ename;
		form.sal.value=data.sal;
		form.job.value=data.job;
		$(form).one('submit', function(e){
			e.preventDefault();
			$(form.ename).removeProp('readonly');
			$(form.sal).removeProp('readonly');
			$(form.job).removeProp('readonly');
			$(form).on('submit', function(e){
				e.preventDefault();
				$.ajax('api/emp/'+idx,{
					method: 'PUT',
					/* contentType 안바꿔주면 못 읽음 */
					contentType:'application/json;charset=utf-8',
					data:JSON.stringify({
						empno:Number(form.empno.value),ename:form.ename.value,
						sal:Number(form.sal.value),job:form.job.value}),
					success: function(data){
						showList();
						$('#myModal').modal('hide');
					}
				});
			});
		});
	});
});

showList();

function showList(){
	$('#emp').empty(); // 누적 방지
	$.get('api/emp/', function(data){
		var arr = data;
		arr.forEach(function(ele, idx){
			var d = new Date();
			d.setTime(Number(ele.hiredate));
			$('<div/>')
				.addClass('panel panel-success')
				.append('<div class="panel-heading">'+d.toLocaleDateString()+" ("+ele.empno+')</div>')
				.append('<div class="panel-body">'+ele.ename
						+' <button class="btn btn-default" data-toggle="modal" data-target="#myModal" data-empno="'
						+ele.empno+'">상세보기</button></div>')
				.appendTo('#emp');
		});
	});
}

$('#addemp form').submit(function(e){
	e.preventDefault();
	$.post('api/emp', $(e.target).serialize(), function(data){
		showList();
		location.href='#emp';
		e.target.empno.value='';
		e.target.ename.value='';
		e.target.sal.value='';
		e.target.job.value='';
	});
});
</script>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
	         <div class="form-group">
	            <label for="empno" class="col-sm-2 control-label">empno</label>
	            <div class="col-sm-10">
	               <input type="text" class="form-control" id="empno" name="empno" placeholder="empno" readonly>
	            </div>
	         </div>
	         <div class="form-group">
	            <label for="ename" class="col-sm-2 control-label">ename</label>
	            <div class="col-sm-10">
	               <input type="text" class="form-control" id="ename" name="ename" placeholder="ename" readonly>
	            </div>
	         </div>
	         <div class="form-group">
	            <label for="sal" class="col-sm-2 control-label">sal</label>
	            <div class="col-sm-10">
	               <input type="text" class="form-control" id="sal" name="sal" placeholder="sal" readonly>
	            </div>
	         </div>
	         <div class="form-group">
	            <label for="job" class="col-sm-2 control-label">job</label>
	            <div class="col-sm-10">
	               <input type="text" class="form-control" id="job" name="job" placeholder="job" readonly>
	            </div>
	         </div>
	         <div class="form-group">
	            <div class="col-sm-offset-2 col-sm-10">
	               <button type="submit" class="btn btn-primary">수정</button>
	               <button type="reset" class="btn btn-default">취소</button>
	               <button type="button" class="btn btn-default" data-dismis="modal">닫기</button>
	            </div>
	         </div>
		</form>
      </div>
    </div>
  </div>
</div>

</body>
</html>