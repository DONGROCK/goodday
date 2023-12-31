<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>FileIO</title>
</head>
<body>
<h1>File Upload</h1>

<h4>cos single file</h4>
<form action="cos/single" method="post" encType="multipart/form-data">
  <input type="file" name="singlefile">
  <br>
  <input type="text" name="description">
  <button type="submit">전송</button>
</form>

<h4>cos many files</h4>
<p>multiple 속성을 이용하지 않고 여러 개의 input type="file"을 이용하면 다중 업로드를 할 수 있다.</p>
<form action="cos/many" method="post" encType="multipart/form-data">
  <input type="file" name="first"><br>
  <input type="file" name="second"><br>
  <input type="file" name="third"><br>
  <input type="text" name="description">
  <button type="submit">전송</button>
</form>

<h4>cos multi files</h4>
<p>cos.jar로는 multiple 속성을 이용하여 파일업로드 처리를 할 수 없다.</p>
<form action="cos/multi" method="post" encType="multipart/form-data">
  <input type="file" name="multifile" multiple>
  <br>
  <input type="text" name="description">
  <button type="submit">전송</button>
</form>

<h4>commons files upload</h4>
<p>commons fileupload를 이용하면 multiple도 가능하며, 파일을 여러 input태그로 업로드 하는 것도 가능하다.</p>
<form action="commons/single" method="post" encType="multipart/form-data">
  <input type="file" name="singlefile" multiple><br>
  <input type="file" name="singlefile2" multiple><br>
  <input type="text" name="description">
  <button type="submit">전송</button>
</form>
<br>
<h4>transfer to thumbnail image</h4>
<button onclick="location.href='transferToThumbnail'">썸네일 이미지 변환하기</button>

</body>
</html>