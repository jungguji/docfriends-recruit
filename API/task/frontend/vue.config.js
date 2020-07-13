const path = require('path')

module.exports = {
    outputDir: path.resolve(__dirname, "../backend/src/main/resources/static"),
    devServer: {
        proxy: {
            '/' : {
                target: 'http://localhost:9000'
                , ws: true
                , changeOrigin: true
            }
        }
    }
}