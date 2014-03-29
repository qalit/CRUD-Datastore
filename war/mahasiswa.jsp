<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="id">
    <head>
        <title>Daftar</title>
    </head>
    <body>
        <h1>Daftar Mahasiswa Jurusan Elektro</h1>
        <a href="/tambah">Daftar Baru</a>
        <table border="1">
            <tr>
                <th>Nama</th>
                <th>NIM</th>
                <th>Email</th>
                <th>No HP</th>
                <th>Aktif</th>
                <th>&nbsp;</th>
                
            </tr>
<c:forEach var="satu" items="${daftar}">
            <tr>
                <td><a href="/ubah?id=${satu.key.id}">${satu.properties.nama}</a></td>
                <td><a href="/ubah?id=${satu.key.id}">${satu.properties.NIM}</a></td>
                <td><a href="/ubah?id=${satu.key.id}">${satu.properties.email}</a></td>
                <td><a href="/ubah?id=${satu.key.id}">${satu.properties.noHP}</a></td>
                <td><a href="/ubah?id=${satu.key.id}">${satu.properties.aktif}</a></td>
                <td><a href="/hapus?id=${satu.key.id}">Hapus</a></td>
            </tr>
</c:forEach>                        
        <table>
    </body>
</html>

