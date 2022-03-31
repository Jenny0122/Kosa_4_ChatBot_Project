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
                  <tr v-for="dp in dryPlant" :key="dp">
                    <th>{{dp.no}}.</th><th>{{dp.plant_name}}</th>
                    <!-- <td>{{ip.chartr_info}}</td>
                    <td>{{ip.flwr_info}}</td>
                    <td>{{ip.light_info}}</td>
                    <td>{{ip.grwt_info}}</td>
                    <td>{{ip.water_cycle_info}}</td>
                    <td>{{ip.batch_place_info}}</td> -->
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
  name: 'DryPlant',
  data() {
    return {
      msg: '건조에 강한 식물',
      subject: '건조한 곳에 키우기 좋은 식물을 추천해드립니다',
      dryPlant: []
    }
  },
  methods: {

  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/dryplant')
    .then((res) => {
      let list = res.data
      for (var i in list) {
        this.dryPlant.push(list[i])
      }
    })
  }
}
</script>
<style scoped>
</style>