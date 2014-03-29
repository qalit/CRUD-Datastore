<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="id">
    <head>
        <title>Daftar Baru Mahasiswa</title>
    </head>
    <body>
        <h1>Daftar Baru</h1>
        <form action="/tambah" method="post">
            Nama: <input type="text" name="txtNama"><br/>
            NIM : <input type="text" name="txtNIM"><br/>
            Email : <input type="text" name="txtEmail"><br/>
            No HP : <input type="text" name="txtNoHP"><br/>
            <select name="txtAktif">
  					<option value="Aktif" >Aktif</option>
					<option value="TidakAktif" >Tidak Aktif</option>
			</select><br/>
            <input type="submit" value="tambah">
        </form>
    </body>
</html>
