<template>
  <div id="page-wrapper">
    <article id="main">
      <header>
        <h2>{{msg}} Page</h2>
        <p>{{subject}}</p>
      </header>
      <section class="wrapper style5">
        <div class="inner">
          <section>
            <div class="table-wrapper">
              <table>
                <thread>
                </thread>
                <tbody>
                  <tr v-for="ap in airPlant" :key="ap">
                    <th>{{ap.no}}.</th><th>{{ap.name}}</th>
                    <!-- <td>{{ip.description}}</td>
                    <td>{{ip.batchrecomm}}</td>
                    <td>{{ip.management}}</td> -->
                  </tr>
                </tbody>
              </table>
            </div>
          </section>
        </div>
      </section>
    </article>
  </div>
</template>
<script>
export default {
  name: 'AirPlant',
  data() {
    return {
      msg: '공기 정화용 식물',
      subject: '공기 정화에 좋은 식물을 추천해드립니다',
      airPlant: []
    }
  },
  methods: {

  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/airplant')
    .then((res) => {
      let list = res.data
      for (var i in list) {
        this.airPlant.push(list[i])
      }
    })
  }
}
</script>
<style scoped>
</style>