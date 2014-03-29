<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="id">
    <head>
        <title>Hapus Data Mahasiswa</title>
    </head>
    <body>
        <h1>Hapus Data Mahasiswa</h1>
        <form action="/hapus" method="post">
            <input type="hidden" name="hdnId" value="${data.key.id}">
            Nama : <input type="text" name="txtNama" value="${data.properties.nama}"disabled><br/>
            NIM : <input type="text" name="txtNIM" value="${data.properties.NIM}"disabled><br/>
            Email : <input type="text" name="txtEmail" value="${data.properties.email}"disabled><br/>
            No HP : <input type="text" name="txtNoHP" value="${data.properties.noHP}"disabled><br/>
            <select name="txtAktif" disabled>
  					<option value="${data.properties.Aktif}" >Aktif</option>
					<option value="${data.properties.Aktif}" >Tidak Aktif</option>
			</select><br/>
            <input type="submit" value="Hapus">
        </form>
    </body>
</html>