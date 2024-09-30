

<template>
<div>
  <h1>오늘의 로또 번호는?</h1>
  <Button @click="generateNumber">나야, 로또번호</Button>
  <div class="lottoNumList">
  <div v-for="(lotto,i) in lottoNum"
       :key="i"
  :style="{ backgroundColor: getRandomColor() }"
  class="lottoNumber">{{lotto}}</div>
  </div>
</div>
</template>
<script setup>

import axios from "axios";
import {computed, reactive, ref} from "vue";


const lottoNum = ref(null);

const generateNumber = () => {
axios.get("/api/generate")
    .then(function (response){
      console.log(response)
      lottoNum.value = response.data.lotto;
    })
    .catch(function (error) {
      console.log(error);
    })
};
const lottoStyle = computed(()=>{
  getRandomColor();
  return
})
const getRandomColor = () =>{
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  console.log(color)
  return color;
};
</script>
<style scoped>
.lottoNumList{
  position: relative;
  margin-top: 10%;
  display: grid;
  grid-template-columns: repeat(6,1fr);
  grid-template-rows: repeat(2, 1fr);
  gap: 10px; /* 팔레트 사이에 간격을 설정 (선택 사항) */
}
.lottoNumber{
  position: relative;
  width: 10vh;
  height: 10vh;
  font-size: 1.8rem;
  font-weight: bold;
  align-content: center;
  border-radius: 50%;
  text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;
}
</style>