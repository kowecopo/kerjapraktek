<?php 

$conn = mysqli_connect('localhost','root','');
mysqli_select_db($conn, 'kp');

date_default_timezone_set("Asia/Jakarta");

$target_dir = "upload";
$image = $_POST['image'];
$image_name = rand()."_".time().".jpeg";
$id_absensi = $_POST['id_absensi'];
$nama_alat = $_POST['nama_alat'];

if (!file_exists($target_dir)) {
	mkdir($target_dir, 0777, true);
}

$target_dir = $target_dir."/".$image_name;
if (file_put_contents($target_dir, base64_decode($image))) {
	echo json_encode([
		"Message" => "The file has been uploaded.",
		"Status" => "OK"
	]);
} else {
	echo json_encode([
		"Message" => "Error uploading.",
		"Status" => "Error"
	]);
}


// $logout_time = date('Y-m-d H:i:s');

if ($conn) {
	$result = mysqli_query($conn, "UPDATE data SET gambar_sesudah='$image_name' WHERE id_absensi='$id_absensi' AND nama_alat='$nama_alat'");
	if ($result) {
		echo "success";
	} else {
		echo "gagal";
	}
} else {
	echo "failed to connect";
}

?>