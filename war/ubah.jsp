<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="id">
    <head>
        <title>Ubah Data Mahasiswa</title>
    </head>
    <body>
        <h1>Ubah Data Mahasiswa</h1>
        <form action="/ubah" method="post">
            <input type="hidden" name="hdnId" value="${data.key.id}">
            Nama : <input type="text" name="txtNama" value="${data.properties.nama}"><br/>
            NIM : <input type="text" name="txtNIM" value="${data.properties.NIM}"><br/>
            Email : <input type="text" name="txtEmail" value="${data.properties.email}"><br/>
            No HP : <input type="text" name="txtNoHP" value="${data.properties.noHP}"><br/>
            Ket : <select name="txtAktif">
  					<option value="Aktif" >Aktif</option>
					<option value="TidakAktif" >Tidak Aktif</option>
			</select><br/>
            
            <input type="submit" value="ubah">
        </form>
    </body>
</html>