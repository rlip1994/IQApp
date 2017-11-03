var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var cors=require('cors');
var routes = require('./routes/index');
var users = require('./routes/users');
var Tasks=require('./routes/Tasks');
var Students=require('./routes/Students');
var categories = require('./routes/categories');
var questions = require('./routes/questions');
var userProfile = require('./routes/userProfile');
var userProfileMod = require('./routes/userProfileMod');
var userRegister = require('./routes/userRegister');
var userLogin = require('./routes/userLogin');
var getAllKids = require('./routes/getAllKids');
var addKid = require('./routes/addKid');
var modKid = require('./routes/modKid');
var getKid = require('./routes/getKid');
var getCountry = require('./routes/getCountry');
var getRegions = require('./routes/getRegions');
var getCities = require('./routes/getCities');
var getSchool = require('./routes/getSchool');
var getGrades = require('./routes/getGrades');
var results = require('./routes/results');
var getValidUser = require('./routes/getValidUser');
var getUsersTypes = require('./routes/getUsersTypes');
var app = express();


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');
// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(cors());
app.use(logger('dev'));
app.use(bodyParser.json({limit: '50mb'}));
app.use(bodyParser.urlencoded({limit: '50mb', extended: false }));

app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
//app.use(express.static('/uploads/'));

/*app.use('/resources',express.static(__dirname + '/images'));
So now, you can use http://localhost:5000/resources/myImage.jpg to serve all the images instead of http://localhost:5000/images/myImage.jpg. */
app.use('/', routes);
app.use('/users', users);
app.use('/Tasks',Tasks);
app.use('/Students',Students);
app.use('/categories',categories);
app.use('/questions',questions);
app.use('/userProfile',userProfile);
app.use('/userProfileMod',userProfileMod);
app.use('/userRegister',userRegister);
app.use('/userLogin',userLogin);
app.use('/getAllKids',getAllKids);
app.use('/addKid',addKid);
app.use('/modKid',modKid);
app.use('/getKid',getKid);
app.use('/getCountry',getCountry);
app.use('/getRegions',getRegions);
app.use('/getCities',getCities);
app.use('/getSchool',getSchool);
app.use('/getGrades',getGrades);
app.use('/results',results);
app.use('/getValidUser',getValidUser);
app.use('/getUsersTypes',getUsersTypes);
// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});


module.exports = app;
