import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  build: {// 빌드 결과물이 생성되는 경로
    outDir: '../lottoNumber/src/main/resources/static'
  },
  server:{
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
        secure: false,
        ws: true,
        xfwd: true,
      },
    }
  },
})
