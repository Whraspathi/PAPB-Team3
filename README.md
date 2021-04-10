# KumBer
KumBer merupakan aplikasi berita berbasis Android yang dibuat untuk memenuhi tugas mata kuliah Pengembangan Aplikasi Piranti Bergerak. Nantinya, aplikasi ini menjadi tempat di mana pengguna bisa membaca berita dari berbagai sumber. Apabila sumber berita dipilih (Kompas.com, Detik.com, dan sebagainya), maka akan muncul sekumpulan berita dari situs tersebut. Apabila dipilih beritanya, maka akan muncul detail dari artikel yang bisa dibaca oleh pengguna.

Lifecycle yang digunakan sama seperti aplikasi pada umumnya. Saat memilih dari sumber berita yang mana, maka aplikasi akan melakukan refresh dan menunjukkan bahwa berita yang ditampilkan adalah berita yang sudah terbaru. Refresh dilakukan ketika aplikasi berada pada lifecycle onResume.

Kumber dikembangkan menggunakan arsitektur MVVM. Arsitektur ini dipilih karena adanya kebutuhan data binding dalam mengakses setiap berita dan dukungan terhadap Android life cycle yang lebih baik.
