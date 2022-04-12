<template>
<div>
    <div class="IndoorplantList">
        <div class="title">INDOORPLANT</div>
        <div class="subtitle">실내식물을 소개합니다:)</div>
    </div>
    <b-table 
    :items="items" 
    :fields="fields" 
    striped 
    responsive="sm" 
    :current-page="currentPage" 
    :per-page="10">
        <template #cell(세부설명)="row">
            <b-button size="sm" @click="row.toggleDetails" class="mr-2">
                <i v-bind:class="row.detailsShowing ? 'fa fa-leaf':'fa fa-leaf'"></i>
            </b-button>
        </template>

        <template #row-details="row">
            <b-card>
                <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>[설명]</b></b-col>
                    <b-col>{{ row.item.fnclty_info }}</b-col>
                </b-row>
            </b-card>
        </template>
    </b-table>
    <b-pagination class="page"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="10" 
            aria-controls="table"/>
</div>
</template>

<script>
export default {
    computed: {
        rows() {
            return this.items.length;
        }
    },
    data() {
        return {
            currentPage: 1,
            fields: ["no", "이름", "세부설명"],
            items: []
        }
    },

    created: function() {
        const getItems = () => {
            this.$axios.get('/indoor_plants')
                .then((res) => {
                    res.data.forEach((item, index) => {
                        this.items.push({
                            'no': index+1,
                            '이름': item.name,
                            // 'lef_stle_info': item.lef_stle_info,
                            // 'prpgt_era_info': item.prpgt_era_info,
                            // 'frtlzr_info': item.frtlzr_info,
                            // 'soil_info': item.soil_info,
                            'fnclty_info': item.fnclty_info,
                            isActive:false,
                        })
                    });
                })
                .catch()
        }

        getItems();            
        console.log(this.items);
    }
}
</script>

<style scoped>
.IndoorplantList {
    font-size: 30px;
	width: 350px;
    height: 150px;
    margin: auto;
}

.title {
    width: fit-content;
    margin: auto;
    height: 90px;
}
.subtitle {
	width: fit-content;
    margin: auto;
}
.page {
    justify-content: center;
}

.mr-2{
    background-color: #557571;
    border: 0;
    cursor: pointer;
    box-shadow: -3px -3px 3px rgb(172, 172, 172), 3px 3px 3px rgb(237, 237, 237);
    transition: 0.3s;
    font-size: 15px;
    width: 100px;
    padding: 5px 5px;
}

</style>