var mysql=require('mysql');
var connection=mysql.createPool({

host:'localhost',
user:'root',
password:'Rlip1994',
database:'mydb'


});
module.exports=connection;