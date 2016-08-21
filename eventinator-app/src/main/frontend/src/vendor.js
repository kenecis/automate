'use strict';
/* JS */
global.$ = global.jQuery = require('jquery');
global.angular = require('angular');
global.moment = require('moment');
require('angular-messages');
require('angular-ui-bootstrap');
require('fullcalendar');
require('angular-ui-calendar');
require('angular-ui-router');
require('angular-resource');

/* Styles*/
require('../node_modules/bootstrap/dist/css/bootstrap.min.css');
require('../node_modules/font-awesome/css/font-awesome.css');
require('../node_modules/fullcalendar/dist/fullcalendar.css');
require('./public/less/main.less');

/* Devcup Automate Modules */
require('./app/app.module');
require('./app/dashboard/dashboard.module');