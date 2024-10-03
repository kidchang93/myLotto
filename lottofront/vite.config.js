import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server:{
    proxy: {
      "/api": {
        target: "http://172.17.0.2:8080",
        changeOrigin: true,
        secure: false,
        ws: true,
        xfwd: true,
      },
    }
  },
})
