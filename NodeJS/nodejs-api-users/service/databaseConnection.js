var mysql = require('promise-mysql');

pool = mysql.createPool({
  host: '127.0.0.1',
  user: 'user',
  password: 'password',
  database: 'nodejs',
  connectionLimit: 10
});

function getSqlConnection() {
  return pool.getConnection().disposer(function(connection) {
    pool.releaseConnection(connection);
  });
}

module.exports = getSqlConnection;
