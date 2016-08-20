'use strict';
/* JS */
global.$ = global.jQuery = require('jquery');
global.angular = require('angular');
global.moment = require('moment');
require('angular-messages');
require('angular-ui-bootstrap');
require('angular-ui-router');
require('angular-resource');

/* Styles*/
require('../node_modules/bootstrap/dist/css/bootstrap.min.css');
require('./public/less/main.less');

/* Devcup Automate Modules */
require('./app/app.module');
require('./app/admin/admin.module');