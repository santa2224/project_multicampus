<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="/scripts/jquery-ui/jquery.min.js"></script>
<script type="text/javascript" src="/scripts/common/common-ui.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
	header, footer{
		display:none;
	}
	body{
		overflow:hidden; 
		width:550px;
		height:800px;
		margin: 0 auto;
	}
	table{
		margin:0 auto;
	}
	.sendSms_table1{
		width:400px;
	}
	.sendSms_table2{
		width:100%;
		display:flex;
		margin: 10px 0 0 11px;
	}
	.sendSms_container{
		width:500px;
		margin:0 auto;
		margin-top:10px;
	}
	h1{
		margin:0;
	}
	.sms_h1{
		font-family: 'GmarketSansMedium';
		text-align:center;
		padding:10px;
		margin:20px 0 20px 0;
	}
	#getn{
		background-color: rgb(8, 32, 50);
	    border: 1px solid gray;
	    color: white;
	}
	#getn2{
		background-color: rgb(8, 32, 50);
	    border: 1px solid gray;
	    color: white;
	    padding:6px;
	    width:40%;
	    margin-left: 10px;
	}
	.sms_font{
		font-family: 'GmarketSansMedium';
		font-size: 20px;
		float:right;
		margin-right:10px;
		margin-top: 4px;
	}
	
	.sendSms_form{
		display:flex;
		text-align:center;
		height:34px;
	}
	tr{
		display:flex;
	}
	.input_box_sms{
		display: inline-block;
	    height: 34px;
	    padding: 6px 12px;
	    font-size: 14px;
	    line-height: 1.42857143;
	    color: #555;
	    background-color: #fff;
	    background-image: none;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	}
	#setn:focus{
		border-color:#0982f0;
	}
</style>

<div class="sendSms_container">
	<h1 class="sms_h1">휴대폰인증</h1>
 
    <form method="post" action="smssend" class="sendSms_form">
        <table class="sendSms_table1">
            <tr class="form-group">
                <td class="sms_font">휴대폰 번호 : </td>
                <td>
                    <input type="text" class="form-control" name="to" placeholder="번호">
                </td>
            </tr>
        </table>
        <button class="btn btn-default" id="getn2">발송</button>  
    </form>
    
    <table class="sendSms_table2">
    	<tr>
		    <td class="sms_font">인증번호 : </td>
		    <td>
		    	<input type="text"  placeholder="인증번호를 입력하세요" id="setn" class="input_box_sms">
		    	<button class="btn btn-default" id="getn">확인</button>	
		   	</td>
		   	
		</tr>
 	</table>
 		
 </div>
 
 <script>
 	var target = document.getElementById('getn');

 	
 	$(function(){
 		$("#getn").click(function(){
 			var inputVal = $("#setn").val();
 			if(inputVal =="${Anumber}"){
 				
 				alert("인증이 완료되었습니다.");
 				target.disabled = true;
 				window.close();
 				return false;
 				
 			}else{
 				alert("인증에 실패하였습니다.");
 				return false;
 			}
 		});
 	});
 	
 </script>

