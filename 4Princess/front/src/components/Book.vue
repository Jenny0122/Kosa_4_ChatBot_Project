<template>
  <div id = 'app'>
      <h3> 관련 서적 </h3>
      <table>
          <thead>
              <th v-for='header in headers' :key='header'>{{header}}</th>
          </thead>
          <tbody>
              <tr v-for='line in ranking' :key='line'>
                  <td v-for='item in line' :key='item'>{{ item }}</td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>
export default {
  el: '#app',
  name: 'Book',
  data() {
    return {
      headers: ['프로그래밍 언어', '2018', '2013', '2008', '2003', '1998'],
      ranking: [
          ['java', 1, 2, 1, 1, 16],
          ['c', 2, 1, 2, 2, 1],
          ['c++', 3, 4, 3, 3, 2],
          ['python', 4, 7, 6, 11, 23],
          ['JS', 17, 18, 8, 7, 20],
          ['Vue', 10, 15, 28, 45, 100]
      ]
    }
  }
}
</script>
<style>
    table{
    width: 75%;
    text-align : left;
    }
    tanle th{
        padding : 12px;
        border-bottom: 2px solid  darkgray;
    }
    table td{
        padding : 12px;
    }
    table tr:nth-of-type(even){
        background-color: rgba(0,0,255,0.1);
    }
</style>