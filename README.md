### This task is about fetching data from the database and generating xml file with it 
```xml
<tableModel>
	<schema schemaName="OKUL">
		<table tableName="DERS">
			<column name="ID" type="number" size="10" precision="0" default="" nullable=false />
			<column name="KODU" type="varchar" size="10" precision="0" default="" nullable=false />
			<column name="ADI" type="varchar" size="255" precision="0" default="" nullable=false />
			<column name="AKTIF" type="number" size="1" precision="0" default="0" nullable=false />
		</table>
		<table tableName="OGRENCI">
			<column name="ID" type="number" size="10" precision="0" default="" nullable=false />
			<column name="KODU" type="varchar" size="10" precision="0" default="" nullable=false />
			<column name="ADI" type="varchar" size="255" precision="0" default="" nullable=false />
			<column name="AKTIF" type="number" size="1" precision="0" default="0" nullable=false />
		</table>
		<table tableName="EGITMEN">
			<column name="ID" type="number" size="10" precision="0" default="" nullable=false />
			<column name="KODU" type="varchar" size="10" precision="0" default="" nullable=false />
			<column name="ADI" type="varchar" size="255" precision="0" default="" nullable=false />
			<column name="AKTIF" type="number" size="1" precision="0" default="0" nullable=false />
		</table>
	</schema>
</tableModel>
```


1 - Veri tablosu yapısını barındıran aşağıdaki formatta xml dosyası var.
2 - Bu xml dosyasını JAXB ile işle
3 - aktif bir veri tabanından (mssql, mysql, oracle) kendi bilgilsayarında bu formatta xml oluşacak
4 - iki şablon dosyasını karşılaştırarak farklılıkları bul
