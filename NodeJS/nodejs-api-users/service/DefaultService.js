'use strict';

var Promise = require("bluebird");
var getSqlConnection = require('./databaseConnection');

/**
 * Get all users
 *
 * returns List
 **/
exports.usersGET = function() {
    return new Promise.using(getSqlConnection(), function(connection) {
        return Promise.map(connection.query('SELECT * FROM users'), function(item) {
            return Promise.all([
                connection.query('SELECT id, country, state, city, street, zip FROM addresses WHERE user_id = '+item.id).then(function(addrs) {
                    item.address = addrs;
                })
            ]).then(function() {
                return item;
            });
        }).then(function(results) {
            return results;
        }).catch(function(err) {
            console.log(err);
        });
    });
}

/**
 *
 * user User 
 * returns user
 **/
exports.usersPOST = function(user) {
    return new Promise.using(getSqlConnection(), function(connection) {
        var sql = 'INSERT INTO users (name, email, password, birthDate) VALUES (\''+user.name+'\',\''+user.email+'\',\''+user.password+'\',\''+user.birthDate+'\')';
        return connection.query(sql).then(function(rows) {
            user.id = rows.insertId;
            var sql = 'INSERT INTO addresses (user_id, country, state, city, street, zip) VALUES (\''+user.id+'\',\''+user.address.country+'\',\''+user.address.state+'\',\''+user.address.city+'\',\''+user.address.street+'\',\''+user.address.zip+'\')';
            return connection.query(sql).then(function(rows) {
                user.address.id = rows.insertId;
                return user;
            }).catch(function(error) {
                console.log(error);
            });
        }).catch(function(error) {
            console.log(error);
        });
    });
}

/**
 *
 * userId Integer 
 * no response value expected for this operation
 **/
exports.usersUserIdDELETE = function(userId) {
    return new Promise.using(getSqlConnection(), function(connection) {
        return connection.query('DELETE FROM addresses WHERE user_id='+userId).then(function(rows) {
            return connection.query('DELETE FROM users WHERE id='+userId).then(function(rows) {
                return true;
            }).catch(function(error) {
                console.log(error);
            });
        }).catch(function(error) {
            console.log(error);
        });
    });
}


/**
 * Get one user
 *
 * userId Integer 
 * returns user
 **/
exports.usersUserIdGET = function(userId) {
    return new Promise.using(getSqlConnection(), function(connection) {
        return Promise.map(connection.query('SELECT * FROM users WHERE id='+userId), function(item) {
            return Promise.all([
                connection.query('SELECT id, country, state, city, street, zip FROM addresses WHERE user_id = '+item.id).then(function(addrs) {
                    item.address = addrs;
                })
            ]).then(function() {
                return item;
            });
        }).then(function(results) {
            return results;
        }).catch(function(err) {
            console.log(err);
        });
    });
}


/**
 *
 * userId Integer 
 * user User 
 * returns user
 **/
exports.usersUserIdPUT = function(userId,user) {
    console.log(user);
    return new Promise.using(getSqlConnection(), function(connection) {
        var sql = 'UPDATE users SET name=\''+user.name+'\', email=\''+user.email+'\', birthDate=\''+user.birthDate+'\' WHERE id=\''+userId+'\'';
        return connection.query(sql).then(function(rows) {
            user.id = rows.insertId;
            var sql = 'UPDATE addresses SET country=\''+user.address.country+'\', state=\''+user.address.state+'\', city=\''+user.address.city+'\', street=\''+user.address.street+'\', zip=\''+user.address.zip+'\' WHERE id = '+user.address.id;
            console.log(sql);
            return connection.query(sql).then(function(rows) {
                user.address.id = rows.insertId;
                return user;
            }).catch(function(error) {
                console.log(error);
            });
        }).catch(function(error) {
            console.log(error);
        });
    });
}

