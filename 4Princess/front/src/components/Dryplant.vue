<template>
<div>
    <div class="DryplantList">
        <div class='title'>DRYPLANT</div>
        <div class='subtitle'>건조식물을 소개합니다:)</div>
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
                {{ row.detailsShowing ? '숨기기' : '자세히 보기'}} 
            </b-button>
        </template>

        <template #row-details="row">
            <b-card>
                <b-row class="mb-2">
                    <b-col sm="3" class="text-sm-right"><b>[설명]</b></b-col>
                    <b-col>{{ row.item.chartr_info }}</b-col>
                </b-row>
                <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>[꽃의 특징]</b></b-col>
                    <b-col>{{ row.item.flwr_info }}</b-col>
                </b-row>
                <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>[빛]</b></b-col>
                    <b-col>{{ row.item.light_info }}</b-col>
                </b-row>
                <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>[생장형]</b></b-col>
                    <b-col>{{ row.item.grwt_info }}</b-col>
                </b-row>
                <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>[급수주기]</b></b-col>
                    <b-col>{{ row.item.water_cylce_info }}</b-col>
                </b-row>
                <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>[추천배치장소]</b></b-col>
                    <b-col>{{ row.item.batch_place_info}}</b-col>
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
            fields: ['no', '이름', '세부설명'],
            items: []
        }
    },

    created: function() {
        const getItems = () => {
            this.$axios.get('/dry_plants')
                .then((res) => {
                    res.data.forEach((item, index) => {
                        this.items.push({
                            'no': item.no,
                            '이름': item.plant_name,
                            'chartr_info': item.chartr_info,
                            'flwr_info': item.flwr_info,
                            'light_info': item.light_info,
                            'grwt_info': item.grwt_info,
                            'water_cylce_info': item.water_cylce_info,
                            'batch_place_info': item.batch_place_info,
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
.DryplantList {
    font-size: 30px;
	width: 350px;
    height: 150px;
    margin: auto;
    }

.title{
    width: fit-content;
    margin: auto;
    height: 90px;
}
.subtitle {
	width: fit-content;
    margin: auto 
}
.page{
justify-content: center; 
}

</style>