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
                  <tr v-for="ip in insidePlant" :key="ip">
                    <th>{{ip.no}}.</th><th>{{ip.plant_name}}</th>
                    <!-- <td>{{ip.lef_stle_info}}</td>
                    <td>{{ip.prpgt_era_info}}</td>
                    <td>{{ip.frtlzr_info}}</td>
                    <td>{{ip.soil_info}}</td>
                    <td>{{ip.fnclty_info}}</td> -->
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
  name: 'InsidePlant',
  data() {
    return {
      msg: '실내에서 키우기 좋은 식물',
      subject: '실내에서 키우기 좋은 식물을 추천해드립니다',
      insidePlant: []
    }
  },
  methods: {

  },
  beforeCreate: function() {
    console.log('beforeCreate')

    this.$axios.get('/insideplant')
    .then((res) => {
      let list = res.data
      for (var i in list) {
        this.insidePlant.push(list[i])
      }
    })
  }
}
</script>
<style scoped>
</style>