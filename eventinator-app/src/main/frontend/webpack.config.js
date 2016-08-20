require('webpack');
var autoprefixer = require('autoprefixer');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var CopyWebpackPlugin = require('copy-webpack-plugin');
var srcDir = './src';
var targetDir = '../../../target/classes/static';


module.exports = {
    entry: {
        'vendor': srcDir + '/vendor.js',
        'app': srcDir + '/bootstrap.js'
    },
    output: {
        path: targetDir,
        filename: 'js/[name].js'
    },
    resolve: {
        cache: false,
        root: srcDir,
        // only discover files that have those extensions
        extensions: ['', '.js', '.css', '.less', '.html']
    },
    module: {
        preLoaders: [
            {
                test: /\.js$/,
                loader: 'jshint',
                include: /src/,
                exclude: /node_modules/
            }
        ],
        loaders: [
            {
                test: /\.css$/,
                loader: ExtractTextPlugin.extract('style', 'css?sourceMap!postcss')
            },
            {
                test: /\.less$/,
                loader: ExtractTextPlugin.extract('style', 'css!less')
            },
            {
                test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: 'url?limit=10000&mimetype=application/font-woff!file?name=fonts/[name].[ext]'
            },
            {
                test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: 'file?name=/fonts/[name].[ext]'
            },
            {
                test: /\.html$/,
                loader: 'raw'
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './src/app/index.html',
            inject: 'body'
        }),
        new ExtractTextPlugin('css/main.css'),
        new CopyWebpackPlugin([{
            from: {
                glob: './src/public/'
            },
            to: targetDir + '/',
            ignore: [
                {
                    glob: 'less/**'
                }
            ]
        }])
    ],
    postcss: [
        autoprefixer({
            browsers: ['last 2 version']
        })
    ],
    jshint: {
        emitErrors: true,
        failOnHint: true
    }
}
;