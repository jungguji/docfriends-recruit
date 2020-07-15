const path = require('path')

module.exports = {
    assetsDir: "static",
    outputDir: path.resolve(__dirname, "../backend/src/main/resources/static"),
    indexPath: "../templates/index.html",
    devServer: {
        proxy: {
            '/' : {
                target: 'http://localhost:9000'
                , ws: true
                , changeOrigin: true
            }
        }
    },
    chainWebpack: config => {
        const svgRule = config.module.rule("svg");
        svgRule.uses.clear();
        svgRule.use("vue-svg-loader").loader("vue-svg-loader");
      }
}