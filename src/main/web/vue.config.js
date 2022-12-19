module.exports = {
  publicPath: '/',
  outputDir: '../webapp',
  assetsDir: 'static',
  transpileDependencies: true,
  configureWebpack: {
    resolve: {
      alias: {
        'assets': '@/assets',
        'components': '@/components',
        'network': '@/network',
      }
    }
  }
}
