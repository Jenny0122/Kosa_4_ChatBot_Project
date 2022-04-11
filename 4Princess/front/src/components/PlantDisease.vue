<template>
<div id="page-wrapper">
    <article id="main">
    <header>
        <h2 class="title">{{msg}} Page</h2>
        <p class="subtitle">{{subject}}</p>
    </header>
        <section class="wrapper alt style2">
        <div class="inner">
            <br/><br/>
            <div v-show="show_three">
                <ul class="features">
                    <li>
                        <h2>{{choiceDis.crop_name}}({{choiceDis.sick_name_kor}})</h2>
                        <img :src="`${choiceDis.ori_img}`" />
                    </li>
                    <li>
                        <h3>증상</h3>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;{{choiceDis.symptoms}}</p>
                        <h3>예방법</h3>
                        <p v-html="choiceDis.prevention_method"></p>
                    </li>
                </ul>
                <button  @click="handle_disease('back')">뒤로가기</button>
            </div>
            <div v-show="show_two">
                <div class="sub">
                    질병명을 선택해주세요.
                </div>
                <div class="ulbox">
                    <br/>
                    <div class="category">{{choiceName}}</div>
                    <ul v-for="(val, idx) in pnames[choiceId]" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val.sick_name_kor}`" class="more" @click="handle_disease(val)">{{val.sick_name_kor}}</a></li>
                    </ul>
                </div>
                <p class="hiddenword">.</p>
                <button  @click="handle_toggle()">뒤로가기</button>
            </div>
            <div v-show="show_one">
                <div class="sub">
                    작물을 선택해주세요.
                </div>
                <div class="ulbox">
                    <div class="category">ㄱ</div>
                    <ul v-for="(val, idx) in pnames['pname01']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㄴ</div>
                    <ul v-for="(val, idx) in pnames['pname02']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㄷ</div>
                    <ul v-for="(val, idx) in pnames['pname03']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅁ</div>
                    <ul v-for="(val, idx) in pnames['pname04']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅂ</div>
                    <ul v-for="(val, idx) in pnames['pname05']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅅ</div>
                    <ul v-for="(val, idx) in pnames['pname06']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅇ</div>
                    <ul v-for="(val, idx) in pnames['pname07']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅈ</div>
                    <ul v-for="(val, idx) in pnames['pname08']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅊ</div>
                    <ul v-for="(val, idx) in pnames['pname09']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅋ</div>
                    <ul v-for="(val, idx) in pnames['pname10']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅌ</div>
                    <ul v-for="(val, idx) in pnames['pname11']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅍ</div>
                    <ul v-for="(val, idx) in pnames['pname12']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
                <div class="ulbox">
                    <div class="category">ㅎ</div>
                    <ul v-for="(val, idx) in pnames['pname13']" :key="idx">
                        <li><a :href="`/info/plantdisease/#${val['name']}`" class="more" @click="handle_toggle(`${val['name']}`, `${val['id']}`)">{{val['name']}}</a></li>
                    </ul>
                </div>
            </div>
            <p class="hiddenword">.</p>
        </div>
      </section>
    </article>
  </div>
</template>
<script>
export default {
name: 'PlantDisease',
data() {
    return {
        show_one: true,
        show_two: false,
        show_three: false,
        msg: '식물 질병',
        subject: '식물의 질병에 관한 정보를 제공합니다.:)',
        choiceName: '',
        choiceId: '',
        choiceDis: [],
        pnames: {
            pname01: [{'name': '가지', 'id': 'plant001'},
                    {'name': '감', 'id': 'plant002'},
                    {'name': '감귤', 'id': 'plant003'},
                    {'name': '감자', 'id': 'plant004'},
                    {'name': '감초', 'id': 'plant005'},
                    {'name': '갓', 'id': 'plant006'},
                    {'name': '갯기름나물', 'id': 'plant007'},
                    {'name': '거베라', 'id': 'plant008'},
                    {'name': '고구마', 'id': 'plant009'},
                    {'name': '고려엉겅퀴', 'id': 'plant010'},
                    {'name': '고무나무', 'id': 'plant011'},
                    {'name': '고본', 'id': 'plant012'},
                    {'name': '고추', 'id': 'plant013'},
                    {'name': '고추냉이', 'id': 'plant014'},
                    {'name': '과꽃', 'id': 'plant015'},
                    {'name': '관음죽', 'id': 'plant016'},
                    {'name': '구기자', 'id': 'plant017'},
                    {'name': '국화', 'id': 'plant018'},
                    {'name': '군자란', 'id': 'plant019'},
                    {'name': '글라디올러스', 'id': 'plant020'},
                    {'name': '금어초', 'id': 'plant021'},
                    {'name': '기장', 'id': 'plant022'},
                    {'name': '꽃양배추', 'id': 'plant023'}],
            pname02: [{'name': '냉이', 'id': 'plant024'},
                    {'name': '녹두', 'id': 'plant025'},
                    {'name': '논벼', 'id': 'plant026'}],
            pname03: [{'name': '당근', 'id': 'plant027'},
                    {'name': '대추', 'id': 'plant028'},
                    {'name': '더덕', 'id': 'plant029'},
                    {'name': '도라지', 'id': 'plant030'},
                    {'name': '도라지(길경)', 'id': 'plant031'},
                    {'name': '동백나무', 'id': 'plant032'},
                    {'name': '들깨', 'id': 'plant033'},
                    {'name': '딸기', 'id': 'plant034'},
                    {'name': '땅콩', 'id': 'plant035'}],
            pname04: [{'name': '마(산약)', 'id': 'plant036'},
                    {'name': '마늘', 'id': 'plant037'},
                    {'name': '망고', 'id': 'plant038'},
                    {'name': '매실', 'id': 'plant039'},
                    {'name': '맥문동', 'id': 'plant040'},
                    {'name': '머위', 'id': 'plant041'},
                    {'name': '메론', 'id': 'plant042'},
                    {'name': '모과', 'id': 'plant043'},
                    {'name': '무', 'id': 'plant044'},
                    {'name': '무궁화', 'id': 'plant045'},
                    {'name': '무화과', 'id': 'plant046'},
                    {'name': '미나리', 'id': 'plant047'},
                    {'name': '밀', 'id': 'plant048'}],
            pname05: [{'name': '밤', 'id': 'plant049'},
                    {'name': '배', 'id': 'plant050'},
                    {'name': '배추', 'id': 'plant051'},
                    {'name': '백작약', 'id': 'plant052'},
                    {'name': '백합(나리)', 'id': 'plant053'},
                    {'name': '보리', 'id': 'plant054'},
                    {'name': '복분자', 'id': 'plant055'},
                    {'name': '복숭아', 'id': 'plant056'},
                    {'name': '봉숭아(봉선화)', 'id': 'plant057'},
                    {'name': '부추', 'id': 'plant058'},
                    {'name': '붓꽃', 'id': 'plant059'},
                    {'name': '브로콜리(녹색꽃양배추)', 'id': 'plant060'},
                    {'name': '블루베리', 'id': 'plant061'},
                    {'name': '비름', 'id': 'plant062'},
                    {'name': '비파', 'id': 'plant063'}],
            pname06: [{'name': '사과', 'id': 'plant064'},
                    {'name': '산마늘', 'id': 'plant065'},
                    {'name': '산수유', 'id': 'plant066'},
                    {'name': '살구', 'id': 'plant067'},
                    {'name': '삽주', 'id': 'plant068'},
                    {'name': '상추', 'id': 'plant069'},
                    {'name': '샐러리', 'id': 'plant070'},
                    {'name': '생강', 'id': 'plant071'},
                    {'name': '석류나무', 'id': 'plant072'},
                    {'name': '선인장', 'id': 'plant073'},
                    {'name': '수국', 'id': 'plant074'},
                    {'name': '수박', 'id': 'plant075'},
                    {'name': '수수', 'id': 'plant076'},
                    {'name': '순무', 'id': 'plant077'},
                    {'name': '스타티스', 'id': 'plant078'},
                    {'name': '스파티필럼', 'id': 'plant079'},
                    {'name': '시금치', 'id': 'plant080'},
                    {'name': '식나무', 'id': 'plant081'},
                    {'name': '심비디움', 'id': 'plant082'},
                    {'name': '쑥갓', 'id': 'plant083'}],
            pname07: [{'name': '아로니아', 'id': 'plant084'},
                    {'name': '아마릴리스', 'id': 'plant085'},
                    {'name': '아스파라거스', 'id': 'plant086'},
                    {'name': '아욱', 'id': 'plant087'},
                    {'name': '안개꽃', 'id': 'plant088'},
                    {'name': '앵두', 'id': 'plant089'},
                    {'name': '양배추', 'id': 'plant090'},
                    {'name': '양파', 'id': 'plant091'},
                    {'name': '여주', 'id': 'plant092'},
                    {'name': '열무', 'id': 'plant093'},
                    {'name': '오미자', 'id': 'plant094'},
                    {'name': '오이', 'id': 'plant095'},
                    {'name': '옥수수', 'id': 'plant096'},
                    {'name': '용과', 'id': 'plant097'},
                    {'name': '우엉', 'id': 'plant098'},
                    {'name': '유자', 'id': 'plant099'}],
            pname08: [{'name': '자두', 'id': 'plant100'},
                    {'name': '작두콩', 'id': 'plant101'},
                    {'name': '작약', 'id': 'plant102'},
                    {'name': '장미', 'id': 'plant103'},
                    {'name': '제라늄', 'id': 'plant104'},
                    {'name': '조', 'id': 'plant105'},
                    {'name': '종려죽', 'id': 'plant106'},
                    {'name': '지치', 'id': 'plant107'},
                    {'name': '지황', 'id': 'plant108'}],
            pname09: [{'name': '참깨', 'id': 'plant109'},
                    {'name': '참나물', 'id': 'plant110'},
                    {'name': '참다래(키위,다래)', 'id': 'plant111'},
                    {'name': '참당귀(당귀)', 'id': 'plant112'},
                    {'name': '참외', 'id': 'plant113'},
                    {'name': '천궁', 'id': 'plant114'},
                    {'name': '청경채', 'id': 'plant115'},
                    {'name': '체리', 'id': 'plant116'},
                    {'name': '초석잠', 'id': 'plant117'},
                    {'name': '치자나무', 'id': 'plant118'}],
            pname10: [{'name': '카네이션', 'id': 'plant119'},
                    {'name': '케일', 'id': 'plant120'},
                    {'name': '콜라비(순무양배추)', 'id': 'plant121'},
                    {'name': '콩', 'id': 'plant122'},
                    {'name': '퀴노아', 'id': 'plant123'}],
            pname11: [{'name': '토마토', 'id': 'plant124'}],
            pname12: [{'name': '파', 'id': 'plant125'},
                    {'name': '파슬리', 'id': 'plant126'},
                    {'name': '팔손이', 'id': 'plant127'},
                    {'name': '팥', 'id': 'plant128'},
                    {'name': '패랭이꽃', 'id': 'plant129'},
                    {'name': '페튜니아', 'id': 'plant130'},
                    {'name': '포도', 'id': 'plant131'}],
            pname13: [{'name': '해바라기', 'id': 'plant132'},
                    {'name': '호두나무', 'id': 'plant133'},
                    {'name': '호박', 'id': 'plant134'},
                    {'name': '황금', 'id': 'plant135'},
                    {'name': '황기', 'id': 'plant136'},
                    {'name': '회향', 'id': 'plant137'}],
            plant001: [],
            plant002: [],
            plant003: [],
            plant004: [],
            plant005: [],
            plant006: [],
            plant007: [],
            plant008: [],
            plant009: [],
            plant010: [],
            plant011: [],
            plant012: [],
            plant013: [],
            plant014: [],
            plant015: [],
            plant016: [],
            plant017: [],
            plant018: [],
            plant019: [],
            plant020: [],
            plant021: [],
            plant022: [],
            plant023: [],
            plant024: [],
            plant025: [],
            plant026: [],
            plant027: [],
            plant028: [],
            plant029: [],
            plant030: [],
            plant031: [],
            plant032: [],
            plant033: [],
            plant034: [],
            plant035: [],
            plant036: [],
            plant037: [],
            plant038: [],
            plant039: [],
            plant040: [],
            plant041: [],
            plant042: [],
            plant043: [],
            plant044: [],
            plant045: [],
            plant046: [],
            plant047: [],
            plant048: [],
            plant049: [],
            plant050: [],
            plant051: [],
            plant052: [],
            plant053: [],
            plant054: [],
            plant055: [],
            plant056: [],
            plant057: [],
            plant058: [],
            plant059: [],
            plant060: [],
            plant061: [],
            plant062: [],
            plant063: [],
            plant064: [],
            plant065: [],
            plant066: [],
            plant067: [],
            plant068: [],
            plant069: [],
            plant070: [],
            plant071: [],
            plant072: [],
            plant073: [],
            plant074: [],
            plant075: [],
            plant076: [],
            plant077: [],
            plant078: [],
            plant079: [],
            plant080: [],
            plant081: [],
            plant082: [],
            plant083: [],
            plant084: [],
            plant085: [],
            plant086: [],
            plant087: [],
            plant088: [],
            plant089: [],
            plant090: [],
            plant091: [],
            plant092: [],
            plant093: [],
            plant094: [],
            plant095: [],
            plant096: [],
            plant097: [],
            plant098: [],
            plant099: [],
            plant100: [],
            plant101: [],
            plant102: [],
            plant103: [],
            plant104: [],
            plant105: [],
            plant106: [],
            plant107: [],
            plant108: [],
            plant109: [],
            plant110: [],
            plant111: [],
            plant112: [],
            plant113: [],
            plant114: [],
            plant115: [],
            plant116: [],
            plant117: [],
            plant118: [],
            plant119: [],
            plant120: [],
            plant121: [],
            plant122: [],
            plant123: [],
            plant124: [],
            plant125: [],
            plant126: [],
            plant127: [],
            plant128: [],
            plant129: [],
            plant130: [],
            plant131: [],
            plant132: [],
            plant133: [],
            plant134: [],
            plant135: [],
            plant136: [],
            plant137: []
        }
    }
  },
  methods: {
    handle_toggle: function(name, id) {
        this.show_one = !this.show_one
        this.show_two = !this.show_two
        // console.log(name + ' ' + id)
        this.choiceName = name
        this.choiceId = id
    },
    handle_disease: function(val) {
        this.show_two = !this.show_two
        this.show_three = !this.show_three
        this.choiceDis = val
        // console.log(this.choiceDis)
    }
  },
  beforeCreate: function() {
    this.$axios.get('/plantdisease')
    .then((res) => {
      let list = res.data
      for (var i in list) {
        list[i]['prevention_method'] = list[i]['prevention_method'].replace(/(?:\r\n|\r|\n)/g, '<br /><br />')
        list[i]['prevention_method'] = list[i]['prevention_method'].split('\n').join('<br />')
        if (list[i]['crop_name'] === '가지') {
            this.pnames['plant001'].push(list[i])
        } else if (list[i]['crop_name'] === '감') {
            this.pnames['plant002'].push(list[i])
        } else if (list[i]['crop_name'] === '감귤') {
            this.pnames['plant003'].push(list[i])
        } else if (list[i]['crop_name'] === '감자') {
            this.pnames['plant004'].push(list[i])
        } else if (list[i]['crop_name'] === '감초') {
            this.pnames['plant005'].push(list[i])
        } else if (list[i]['crop_name'] === '갓') {
            this.pnames['plant006'].push(list[i])
        } else if (list[i]['crop_name'] === '갯기름 나물(식방풍)') {
            this.pnames['plant007'].push(list[i])
        } else if (list[i]['crop_name'] === '거베라') {
            this.pnames['plant008'].push(list[i])
        } else if (list[i]['crop_name'] === '고구마') {
            this.pnames['plant009'].push(list[i])
        } else if (list[i]['crop_name'] === '고려엉겅퀴(곤드레나물)') {
            this.pnames['plant010'].push(list[i])
        } else if (list[i]['crop_name'] === '고무나무') {
            this.pnames['plant011'].push(list[i])
        } else if (list[i]['crop_name'] === '고본') {
            this.pnames['plant012'].push(list[i])
        } else if (list[i]['crop_name'] === '고추') {
            this.pnames['plant013'].push(list[i])
        } else if (list[i]['crop_name'] === '고추냉이') {
            this.pnames['plant014'].push(list[i])
        } else if (list[i]['crop_name'] === '과꽃') {
            this.pnames['plant015'].push(list[i])
        } else if (list[i]['crop_name'] === '관음죽') {
            this.pnames['plant016'].push(list[i])
        } else if (list[i]['crop_name'] === '구기자') {
            this.pnames['plant017'].push(list[i])
        } else if (list[i]['crop_name'] === '국화') {
            this.pnames['plant018'].push(list[i])
        } else if (list[i]['crop_name'] === '군자란') {
            this.pnames['plant019'].push(list[i])
        } else if (list[i]['crop_name'] === '글라디올러스') {
            this.pnames['plant020'].push(list[i])
        } else if (list[i]['crop_name'] === '금어초') {
            this.pnames['plant021'].push(list[i])
        } else if (list[i]['crop_name'] === '기장') {
            this.pnames['plant022'].push(list[i])
        } else if (list[i]['crop_name'] === '꽃양배추') {
            this.pnames['plant023'].push(list[i])
        } else if (list[i]['crop_name'] === '냉이') {
            this.pnames['plant024'].push(list[i])
        } else if (list[i]['crop_name'] === '녹두') {
            this.pnames['plant025'].push(list[i])
        } else if (list[i]['crop_name'] === '논벼') {
            this.pnames['plant026'].push(list[i])
        } else if (list[i]['crop_name'] === '당근') {
            this.pnames['plant027'].push(list[i])
        } else if (list[i]['crop_name'] === '대추') {
            this.pnames['plant028'].push(list[i])
        } else if (list[i]['crop_name'] === '더덕') {
            this.pnames['plant029'].push(list[i])
        } else if (list[i]['crop_name'] === '도라지') {
            this.pnames['plant030'].push(list[i])
        } else if (list[i]['crop_name'] === '도라지(길경)') {
            this.pnames['plant031'].push(list[i])
        } else if (list[i]['crop_name'] === '동백나무') {
            this.pnames['plant032'].push(list[i])
        } else if (list[i]['crop_name'] === '들깨') {
            this.pnames['plant033'].push(list[i])
        } else if (list[i]['crop_name'] === '딸기') {
            this.pnames['plant034'].push(list[i])
        } else if (list[i]['crop_name'] === '땅콩') {
            this.pnames['plant035'].push(list[i])
        } else if (list[i]['crop_name'] === '마') {
            this.pnames['plant036'].push(list[i])
        } else if (list[i]['crop_name'] === '마늘') {
            this.pnames['plant037'].push(list[i])
        } else if (list[i]['crop_name'] === '망고') {
            this.pnames['plant038'].push(list[i])
        } else if (list[i]['crop_name'] === '매실') {
            this.pnames['plant039'].push(list[i])
        } else if (list[i]['crop_name'] === '맥문동') {
            this.pnames['plant040'].push(list[i])
        } else if (list[i]['crop_name'] === '머위') {
            this.pnames['plant041'].push(list[i])
        } else if (list[i]['crop_name'] === '메론') {
            this.pnames['plant042'].push(list[i])
        } else if (list[i]['crop_name'] === '모과') {
            this.pnames['plant043'].push(list[i])
        } else if (list[i]['crop_name'] === '무') {
            this.pnames['plant044'].push(list[i])
        } else if (list[i]['crop_name'] === '무궁화') {
            this.pnames['plant045'].push(list[i])
        } else if (list[i]['crop_name'] === '무화과') {
            this.pnames['plant046'].push(list[i])
        } else if (list[i]['crop_name'] === '미나리') {
            this.pnames['plant047'].push(list[i])
        } else if (list[i]['crop_name'] === '밀') {
            this.pnames['plant048'].push(list[i])
        } else if (list[i]['crop_name'] === '밤') {
            this.pnames['plant049'].push(list[i])
        } else if (list[i]['crop_name'] === '배') {
            this.pnames['plant050'].push(list[i])
        } else if (list[i]['crop_name'] === '배추') {
            this.pnames['plant051'].push(list[i])
        } else if (list[i]['crop_name'] === '백작약') {
            this.pnames['plant052'].push(list[i])
        } else if (list[i]['crop_name'] === '백합') {
            this.pnames['plant053'].push(list[i])
        } else if (list[i]['crop_name'] === '보리') {
            this.pnames['plant054'].push(list[i])
        } else if (list[i]['crop_name'] === '복분자') {
            this.pnames['plant055'].push(list[i])
        } else if (list[i]['crop_name'] === '복숭아') {
            this.pnames['plant056'].push(list[i])
        } else if (list[i]['crop_name'] === '봉숭아') {
            this.pnames['plant057'].push(list[i])
        } else if (list[i]['crop_name'] === '부추') {
            this.pnames['plant058'].push(list[i])
        } else if (list[i]['crop_name'] === '붓꽃') {
            this.pnames['plant059'].push(list[i])
        } else if (list[i]['crop_name'] === '브로콜리') {
            this.pnames['plant060'].push(list[i])
        } else if (list[i]['crop_name'] === '블루베리') {
            this.pnames['plant061'].push(list[i])
        } else if (list[i]['crop_name'] === '비름') {
            this.pnames['plant062'].push(list[i])
        } else if (list[i]['crop_name'] === '비파') {
            this.pnames['plant063'].push(list[i])
        } else if (list[i]['crop_name'] === '사과') {
            this.pnames['plant064'].push(list[i])
        } else if (list[i]['crop_name'] === '산마늘') {
            this.pnames['plant065'].push(list[i])
        } else if (list[i]['crop_name'] === '산수유') {
            this.pnames['plant066'].push(list[i])
        } else if (list[i]['crop_name'] === '살구') {
            this.pnames['plant067'].push(list[i])
        } else if (list[i]['crop_name'] === '삽주') {
            this.pnames['plant068'].push(list[i])
        } else if (list[i]['crop_name'] === '상추') {
            this.pnames['plant069'].push(list[i])
        } else if (list[i]['crop_name'] === '샐러리') {
            this.pnames['plant070'].push(list[i])
        } else if (list[i]['crop_name'] === '생강') {
            this.pnames['plant071'].push(list[i])
        } else if (list[i]['crop_name'] === '석류나무') {
            this.pnames['plant072'].push(list[i])
        } else if (list[i]['crop_name'] === '선인장') {
            this.pnames['plant073'].push(list[i])
        } else if (list[i]['crop_name'] === '수국') {
            this.pnames['plant074'].push(list[i])
        } else if (list[i]['crop_name'] === '수박') {
            this.pnames['plant075'].push(list[i])
        } else if (list[i]['crop_name'] === '수수') {
            this.pnames['plant076'].push(list[i])
        } else if (list[i]['crop_name'] === '순무') {
            this.pnames['plant077'].push(list[i])
        } else if (list[i]['crop_name'] === '스타티스') {
            this.pnames['plant078'].push(list[i])
        } else if (list[i]['crop_name'] === '스파티필럼') {
            this.pnames['plant079'].push(list[i])
        } else if (list[i]['crop_name'] === '시금치') {
            this.pnames['plant080'].push(list[i])
        } else if (list[i]['crop_name'] === '식나무') {
            this.pnames['plant081'].push(list[i])
        } else if (list[i]['crop_name'] === '심비디움') {
            this.pnames['plant082'].push(list[i])
        } else if (list[i]['crop_name'] === '쑥갓') {
            this.pnames['plant083'].push(list[i])
        } else if (list[i]['crop_name'] === '아로니아') {
            this.pnames['plant084'].push(list[i])
        } else if (list[i]['crop_name'] === '아마릴리스') {
            this.pnames['plant085'].push(list[i])
        } else if (list[i]['crop_name'] === '아스파라거스') {
            this.pnames['plant086'].push(list[i])
        } else if (list[i]['crop_name'] === '아욱') {
            this.pnames['plant087'].push(list[i])
        } else if (list[i]['crop_name'] === '안개꽃') {
            this.pnames['plant088'].push(list[i])
        } else if (list[i]['crop_name'] === '앵두') {
            this.pnames['plant089'].push(list[i])
        } else if (list[i]['crop_name'] === '양배추') {
            this.pnames['plant090'].push(list[i])
        } else if (list[i]['crop_name'] === '양파') {
            this.pnames['plant091'].push(list[i])
        } else if (list[i]['crop_name'] === '여주') {
            this.pnames['plant092'].push(list[i])
        } else if (list[i]['crop_name'] === '열무') {
            this.pnames['plant093'].push(list[i])
        } else if (list[i]['crop_name'] === '오미자') {
            this.pnames['plant094'].push(list[i])
        } else if (list[i]['crop_name'] === '오이') {
            this.pnames['plant095'].push(list[i])
        } else if (list[i]['crop_name'] === '옥수수') {
            this.pnames['plant096'].push(list[i])
        } else if (list[i]['crop_name'] === '용과') {
            this.pnames['plant097'].push(list[i])
        } else if (list[i]['crop_name'] === '우엉') {
            this.pnames['plant098'].push(list[i])
        } else if (list[i]['crop_name'] === '유자') {
            this.pnames['plant099'].push(list[i])
        } else if (list[i]['crop_name'] === '자두') {
            this.pnames['plant100'].push(list[i])
        } else if (list[i]['crop_name'] === '작두콩') {
            this.pnames['plant101'].push(list[i])
        } else if (list[i]['crop_name'] === '작약') {
            this.pnames['plant102'].push(list[i])
        } else if (list[i]['crop_name'] === '장미') {
            this.pnames['plant103'].push(list[i])
        } else if (list[i]['crop_name'] === '제라늄') {
            this.pnames['plant104'].push(list[i])
        } else if (list[i]['crop_name'] === '조') {
            this.pnames['plant105'].push(list[i])
        } else if (list[i]['crop_name'] === '종려죽') {
            this.pnames['plant106'].push(list[i])
        } else if (list[i]['crop_name'] === '지치') {
            this.pnames['plant107'].push(list[i])
        } else if (list[i]['crop_name'] === '지황') {
            this.pnames['plant108'].push(list[i])
        } else if (list[i]['crop_name'] === '참깨') {
            this.pnames['plant109'].push(list[i])
        } else if (list[i]['crop_name'] === '참나물') {
            this.pnames['plant110'].push(list[i])
        } else if (list[i]['crop_name'] === '참다래') {
            this.pnames['plant111'].push(list[i])
        } else if (list[i]['crop_name'] === '참당귀') {
            this.pnames['plant112'].push(list[i])
        } else if (list[i]['crop_name'] === '참외') {
            this.pnames['plant113'].push(list[i])
        } else if (list[i]['crop_name'] === '천궁') {
            this.pnames['plant114'].push(list[i])
        } else if (list[i]['crop_name'] === '청경채') {
            this.pnames['plant115'].push(list[i])
        } else if (list[i]['crop_name'] === '체리') {
            this.pnames['plant116'].push(list[i])
        } else if (list[i]['crop_name'] === '초석잠') {
            this.pnames['plant117'].push(list[i])
        } else if (list[i]['crop_name'] === '치자나무') {
            this.pnames['plant118'].push(list[i])
        } else if (list[i]['crop_name'] === '카네이션') {
            this.pnames['plant119'].push(list[i])
        } else if (list[i]['crop_name'] === '케일') {
            this.pnames['plant120'].push(list[i])
        } else if (list[i]['crop_name'] === '콜라비') {
            this.pnames['plant121'].push(list[i])
        } else if (list[i]['crop_name'] === '콩') {
            this.pnames['plant122'].push(list[i])
        } else if (list[i]['crop_name'] === '퀴노아') {
            this.pnames['plant123'].push(list[i])
        } else if (list[i]['crop_name'] === '토마토') {
            this.pnames['plant124'].push(list[i])
        } else if (list[i]['crop_name'] === '파') {
            this.pnames['plant125'].push(list[i])
        } else if (list[i]['crop_name'] === '파슬리') {
            this.pnames['plant126'].push(list[i])
        } else if (list[i]['crop_name'] === '팔손이') {
            this.pnames['plant127'].push(list[i])
        } else if (list[i]['crop_name'] === '팥') {
            this.pnames['plant128'].push(list[i])
        } else if (list[i]['crop_name'] === '패랭이꽃') {
            this.pnames['plant129'].push(list[i])
        } else if (list[i]['crop_name'] === '페튜니아') {
            this.pnames['plant130'].push(list[i])
        } else if (list[i]['crop_name'] === '포도') {
            this.pnames['plant131'].push(list[i])
        } else if (list[i]['crop_name'] === '해바라기') {
            this.pnames['plant132'].push(list[i])
        } else if (list[i]['crop_name'] === '호두나무') {
            this.pnames['plant133'].push(list[i])
        } else if (list[i]['crop_name'] === '호박') {
            this.pnames['plant134'].push(list[i])
        } else if (list[i]['crop_name'] === '황금') {
            this.pnames['plant135'].push(list[i])
        } else if (list[i]['crop_name'] === '황기') {
            this.pnames['plant136'].push(list[i])
        } else if (list[i]['crop_name'] === '회향') {
            this.pnames['plant137'].push(list[i])
        }
      }
    })
  }
}
</script>
<style scoped>
.wrapper.style5 img {
    max-width: 30vw;
    max-height: 30vh;
}
html,
body,
div,
span,
applet,
object,
iframe,
h1,
h2,
h3,
h4,
h5,
h6,
p,
blockquote,
pre,
a,
abbr,
acronym,
address,
big,
cite,
code,
del,
dfn,
em,
img,
ins,
kbd,
q,
s,
samp,
small,
strike,
strong,
sub,
sup,
tt,
var,
b,
u,
i,
center,
dl,
dt,
dd,
ol,
ul,
li,
fieldset,
form,
label,
legend,
table,
caption,
tbody,
tfoot,
thead,
tr,
th,
td,
article,
aside,
canvas,
details,
embed,
figure,
figcaption,
footer,
header,
hgroup,
menu,
nav,
output,
ruby,
section,
summary,
time,
mark,
audio,
video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
}

article,
aside,
details,
figcaption,
figure,
footer,
header,
hgroup,
menu,
nav,
section {
    display: block;
}

body {
    line-height: 1;
}

ol,
ul {
    list-style: none;
}

blockquote,
q {
    quotes: none;
}

blockquote:before,
blockquote:after,
q:before,
q:after {
    content: '';
    content: none;
}

table {
    border-collapse: collapse;
    border-spacing: 0;
}

body {
    -webkit-text-size-adjust: none;
}

mark {
    background-color: transparent;
    color: inherit;
}

input::-moz-focus-inner {
    border: 0;
    padding: 0;
}

input,
select,
textarea {
    -moz-appearance: none;
    -webkit-appearance: none;
    -ms-appearance: none;
    appearance: none;
}


/* Basic */

@-ms-viewport {
    width: device-width;
}

html {
    box-sizing: border-box;
}

*,
*:before,
*:after {
    box-sizing: inherit;
}

body {
    background: #2e3842;
}

body.is-preload *,
body.is-preload *:before,
body.is-preload *:after {
    -moz-animation: none !important;
    -webkit-animation: none !important;
    -ms-animation: none !important;
    animation: none !important;
    -moz-transition: none !important;
    -webkit-transition: none !important;
    -ms-transition: none !important;
    transition: none !important;
}

body,
input,
select,
textarea {
    color: black;
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 15pt;
    font-weight: 400;
    letter-spacing: 0.075em;
    line-height: 1.65em;
}

@media screen and (max-width: 1680px) {
    body,
    input,
    select,
    textarea {
        font-size: 13pt;
    }
}

@media screen and (max-width: 1280px) {
    body,
    input,
    select,
    textarea {
        font-size: 12pt;
    }
}

@media screen and (max-width: 736px) {
    body,
    input,
    select,
    textarea {
        font-size: 11pt;
        letter-spacing: 0.0375em;
    }
}

a {
    -moz-transition: color 0.2s ease, border-bottom-color 0.2s ease;
    -webkit-transition: color 0.2s ease, border-bottom-color 0.2s ease;
    -ms-transition: color 0.2s ease, border-bottom-color 0.2s ease;
    transition: color 0.2s ease, border-bottom-color 0.2s ease;
    border-bottom: none;
    color: inherit;
    text-decoration: none;
}

a:hover {
    border-bottom-color: transparent;
}

strong,
b {
    color: #fff;
    font-weight: 600;
}

em,
i {
    font-style: italic;
}

p {
    margin: 0 0 2em 0;
    color: black;
}

h1,
h2,
h3,
h4,
h5,
h6 {
    color: black;
    font-weight: 800;
    letter-spacing: 0.225em;
    line-height: 1em;
    margin: 0 0 1em 0;
    text-transform: uppercase;
}
.sub {
    font-weight: 800;
    letter-spacing: 0.225em;
    line-height: 1em;
    margin: 0 0 1em 0;
    text-transform: uppercase;
    color: black;
    font-size: 1.5em;
}

h1 a,
h2 a,
h3 a,
h4 a,
h5 a,
h6 a {
    color: inherit;
    text-decoration: none;
}

h2 {
    font-size: 1.5em;
    line-height: 3em;
}

@media screen and (max-width: 736px) {
    h2 {
        font-size: 1.1em;
        line-height: 1.65em;
    }
}

h3 {
    font-size: 1.5em;
    line-height: 3em;
    color: black;
}
.category {
    font-size: 1.5em;
    line-height: 3em;
    color: white;
    margin: 0 0 1em 0;
    padding: 0;
    border: 0;
    vertical-align: baseline;
}

@media screen and (max-width: 736px) {
    h3 {
        font-size: 1em;
        line-height: 1.65em;
    }
}

h4 {
    font-size: 1em;
    line-height: 1.5em;
}

h5 {
    font-size: 0.8em;
    line-height: 1.5em;
}

h6 {
    font-size: 0.7em;
    line-height: 1.5em;
}

sub {
    font-size: 0.8em;
    position: relative;
    top: 0.5em;
}

sup {
    font-size: 0.8em;
    position: relative;
    top: -0.5em;
}

hr {
    border: 0;
    border-bottom: solid 2px #fff;
    margin: 3em 0;
}

hr.major {
    margin: 4.5em 0;
}

blockquote {
    border-left: solid 4px #fff;
    font-style: italic;
    margin: 0 0 2em 0;
    padding: 0.5em 0 0.5em 2em;
}

code {
    background: rgba(144, 144, 144, 0.25);
    border-radius: 3px;
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 0.9em;
    letter-spacing: 0;
    margin: 0 0.25em;
    padding: 0.25em 0.65em;
}

pre {
    -webkit-overflow-scrolling: touch;
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 0.9em;
    margin: 0 0 2em 0;
}

pre code {
    display: block;
    line-height: 1.75em;
    padding: 1em 1.5em;
    overflow-x: auto;
}

.align-left {
    text-align: left;
}

.align-center {
    text-align: center;
}

.align-right {
    text-align: right;
}


/* Row */

.row {
    display: flex;
    flex-wrap: wrap;
    box-sizing: border-box;
    align-items: stretch;
}

.row>* {
    box-sizing: border-box;
}

.row.gtr-uniform>*> :last-child {
    margin-bottom: 0;
}

.row.aln-left {
    justify-content: flex-start;
}

.row.aln-center {
    justify-content: center;
}

.row.aln-right {
    justify-content: flex-end;
}

.row.aln-top {
    align-items: flex-start;
}

.row.aln-middle {
    align-items: center;
}

.row.aln-bottom {
    align-items: flex-end;
}

.row>.imp {
    order: -1;
}

.row>.col-1 {
    width: 8.33333%;
}

.row>.off-1 {
    margin-left: 8.33333%;
}

.row>.col-2 {
    width: 16.66667%;
}

.row>.off-2 {
    margin-left: 16.66667%;
}

.row>.col-3 {
    width: 25%;
}

.row>.off-3 {
    margin-left: 25%;
}

.row>.col-4 {
    width: 33.33333%;
}

.row>.off-4 {
    margin-left: 33.33333%;
}

.row>.col-5 {
    width: 41.66667%;
}

.row>.off-5 {
    margin-left: 41.66667%;
}

.row>.col-6 {
    width: 50%;
}

.row>.off-6 {
    margin-left: 50%;
}

.row>.col-7 {
    width: 58.33333%;
}

.row>.off-7 {
    margin-left: 58.33333%;
}

.row>.col-8 {
    width: 66.66667%;
}

.row>.off-8 {
    margin-left: 66.66667%;
}

.row>.col-9 {
    width: 75%;
}

.row>.off-9 {
    margin-left: 75%;
}

.row>.col-10 {
    width: 83.33333%;
}

.row>.off-10 {
    margin-left: 83.33333%;
}

.row>.col-11 {
    width: 91.66667%;
}

.row>.off-11 {
    margin-left: 91.66667%;
}

.row>.col-12 {
    width: 100%;
}

.row>.off-12 {
    margin-left: 100%;
}

.row.gtr-0 {
    margin-top: 0;
    margin-left: 0em;
}

.row.gtr-0>* {
    padding: 0 0 0 0em;
}

.row.gtr-0.gtr-uniform {
    margin-top: 0em;
}

.row.gtr-0.gtr-uniform>* {
    padding-top: 0em;
}

.row.gtr-25 {
    margin-top: 0;
    margin-left: -0.375em;
}

.row.gtr-25>* {
    padding: 0 0 0 0.375em;
}

.row.gtr-25.gtr-uniform {
    margin-top: -0.375em;
}

.row.gtr-25.gtr-uniform>* {
    padding-top: 0.375em;
}

.row.gtr-50 {
    margin-top: 0;
    margin-left: -0.75em;
}

.row.gtr-50>* {
    padding: 0 0 0 0.75em;
}

.row.gtr-50.gtr-uniform {
    margin-top: -0.75em;
}

.row.gtr-50.gtr-uniform>* {
    padding-top: 0.75em;
}

.row {
    margin-top: 0;
    margin-left: -1.5em;
}

.row>* {
    padding: 0 0 0 1.5em;
}

.row.gtr-uniform {
    margin-top: -1.5em;
}

.row.gtr-uniform>* {
    padding-top: 1.5em;
}

.row.gtr-150 {
    margin-top: 0;
    margin-left: -2.25em;
}

.row.gtr-150>* {
    padding: 0 0 0 2.25em;
}

.row.gtr-150.gtr-uniform {
    margin-top: -2.25em;
}

.row.gtr-150.gtr-uniform>* {
    padding-top: 2.25em;
}

.row.gtr-200 {
    margin-top: 0;
    margin-left: -3em;
}

.row.gtr-200>* {
    padding: 0 0 0 3em;
}

.row.gtr-200.gtr-uniform {
    margin-top: -3em;
}

.row.gtr-200.gtr-uniform>* {
    padding-top: 3em;
}

@media screen and (max-width: 1680px) {
    .row {
        display: flex;
        flex-wrap: wrap;
        box-sizing: border-box;
        align-items: stretch;
    }
    .row>* {
        box-sizing: border-box;
    }
    .row.gtr-uniform>*> :last-child {
        margin-bottom: 0;
    }
    .row.aln-left {
        justify-content: flex-start;
    }
    .row.aln-center {
        justify-content: center;
    }
    .row.aln-right {
        justify-content: flex-end;
    }
    .row.aln-top {
        align-items: flex-start;
    }
    .row.aln-middle {
        align-items: center;
    }
    .row.aln-bottom {
        align-items: flex-end;
    }
    .row>.imp-xlarge {
        order: -1;
    }
    .row>.col-1-xlarge {
        width: 8.33333%;
    }
    .row>.off-1-xlarge {
        margin-left: 8.33333%;
    }
    .row>.col-2-xlarge {
        width: 16.66667%;
    }
    .row>.off-2-xlarge {
        margin-left: 16.66667%;
    }
    .row>.col-3-xlarge {
        width: 25%;
    }
    .row>.off-3-xlarge {
        margin-left: 25%;
    }
    .row>.col-4-xlarge {
        width: 33.33333%;
    }
    .row>.off-4-xlarge {
        margin-left: 33.33333%;
    }
    .row>.col-5-xlarge {
        width: 41.66667%;
    }
    .row>.off-5-xlarge {
        margin-left: 41.66667%;
    }
    .row>.col-6-xlarge {
        width: 50%;
    }
    .row>.off-6-xlarge {
        margin-left: 50%;
    }
    .row>.col-7-xlarge {
        width: 58.33333%;
    }
    .row>.off-7-xlarge {
        margin-left: 58.33333%;
    }
    .row>.col-8-xlarge {
        width: 66.66667%;
    }
    .row>.off-8-xlarge {
        margin-left: 66.66667%;
    }
    .row>.col-9-xlarge {
        width: 75%;
    }
    .row>.off-9-xlarge {
        margin-left: 75%;
    }
    .row>.col-10-xlarge {
        width: 83.33333%;
    }
    .row>.off-10-xlarge {
        margin-left: 83.33333%;
    }
    .row>.col-11-xlarge {
        width: 91.66667%;
    }
    .row>.off-11-xlarge {
        margin-left: 91.66667%;
    }
    .row>.col-12-xlarge {
        width: 100%;
    }
    .row>.off-12-xlarge {
        margin-left: 100%;
    }
    .row.gtr-0 {
        margin-top: 0;
        margin-left: 0em;
    }
    .row.gtr-0>* {
        padding: 0 0 0 0em;
    }
    .row.gtr-0.gtr-uniform {
        margin-top: 0em;
    }
    .row.gtr-0.gtr-uniform>* {
        padding-top: 0em;
    }
    .row.gtr-25 {
        margin-top: 0;
        margin-left: -0.375em;
    }
    .row.gtr-25>* {
        padding: 0 0 0 0.375em;
    }
    .row.gtr-25.gtr-uniform {
        margin-top: -0.375em;
    }
    .row.gtr-25.gtr-uniform>* {
        padding-top: 0.375em;
    }
    .row.gtr-50 {
        margin-top: 0;
        margin-left: -0.75em;
    }
    .row.gtr-50>* {
        padding: 0 0 0 0.75em;
    }
    .row.gtr-50.gtr-uniform {
        margin-top: -0.75em;
    }
    .row.gtr-50.gtr-uniform>* {
        padding-top: 0.75em;
    }
    .row {
        margin-top: 0;
        margin-left: -1.5em;
    }
    .row>* {
        padding: 0 0 0 1.5em;
    }
    .row.gtr-uniform {
        margin-top: -1.5em;
    }
    .row.gtr-uniform>* {
        padding-top: 1.5em;
    }
    .row.gtr-150 {
        margin-top: 0;
        margin-left: -2.25em;
    }
    .row.gtr-150>* {
        padding: 0 0 0 2.25em;
    }
    .row.gtr-150.gtr-uniform {
        margin-top: -2.25em;
    }
    .row.gtr-150.gtr-uniform>* {
        padding-top: 2.25em;
    }
    .row.gtr-200 {
        margin-top: 0;
        margin-left: -3em;
    }
    .row.gtr-200>* {
        padding: 0 0 0 3em;
    }
    .row.gtr-200.gtr-uniform {
        margin-top: -3em;
    }
    .row.gtr-200.gtr-uniform>* {
        padding-top: 3em;
    }
}

@media screen and (max-width: 1280px) {
    .row {
        display: flex;
        flex-wrap: wrap;
        box-sizing: border-box;
        align-items: stretch;
    }
    .row>* {
        box-sizing: border-box;
    }
    .row.gtr-uniform>*> :last-child {
        margin-bottom: 0;
    }
    .row.aln-left {
        justify-content: flex-start;
    }
    .row.aln-center {
        justify-content: center;
    }
    .row.aln-right {
        justify-content: flex-end;
    }
    .row.aln-top {
        align-items: flex-start;
    }
    .row.aln-middle {
        align-items: center;
    }
    .row.aln-bottom {
        align-items: flex-end;
    }
    .row>.imp-large {
        order: -1;
    }
    .row>.col-1-large {
        width: 8.33333%;
    }
    .row>.off-1-large {
        margin-left: 8.33333%;
    }
    .row>.col-2-large {
        width: 16.66667%;
    }
    .row>.off-2-large {
        margin-left: 16.66667%;
    }
    .row>.col-3-large {
        width: 25%;
    }
    .row>.off-3-large {
        margin-left: 25%;
    }
    .row>.col-4-large {
        width: 33.33333%;
    }
    .row>.off-4-large {
        margin-left: 33.33333%;
    }
    .row>.col-5-large {
        width: 41.66667%;
    }
    .row>.off-5-large {
        margin-left: 41.66667%;
    }
    .row>.col-6-large {
        width: 50%;
    }
    .row>.off-6-large {
        margin-left: 50%;
    }
    .row>.col-7-large {
        width: 58.33333%;
    }
    .row>.off-7-large {
        margin-left: 58.33333%;
    }
    .row>.col-8-large {
        width: 66.66667%;
    }
    .row>.off-8-large {
        margin-left: 66.66667%;
    }
    .row>.col-9-large {
        width: 75%;
    }
    .row>.off-9-large {
        margin-left: 75%;
    }
    .row>.col-10-large {
        width: 83.33333%;
    }
    .row>.off-10-large {
        margin-left: 83.33333%;
    }
    .row>.col-11-large {
        width: 91.66667%;
    }
    .row>.off-11-large {
        margin-left: 91.66667%;
    }
    .row>.col-12-large {
        width: 100%;
    }
    .row>.off-12-large {
        margin-left: 100%;
    }
    .row.gtr-0 {
        margin-top: 0;
        margin-left: 0em;
    }
    .row.gtr-0>* {
        padding: 0 0 0 0em;
    }
    .row.gtr-0.gtr-uniform {
        margin-top: 0em;
    }
    .row.gtr-0.gtr-uniform>* {
        padding-top: 0em;
    }
    .row.gtr-25 {
        margin-top: 0;
        margin-left: -0.375em;
    }
    .row.gtr-25>* {
        padding: 0 0 0 0.375em;
    }
    .row.gtr-25.gtr-uniform {
        margin-top: -0.375em;
    }
    .row.gtr-25.gtr-uniform>* {
        padding-top: 0.375em;
    }
    .row.gtr-50 {
        margin-top: 0;
        margin-left: -0.75em;
    }
    .row.gtr-50>* {
        padding: 0 0 0 0.75em;
    }
    .row.gtr-50.gtr-uniform {
        margin-top: -0.75em;
    }
    .row.gtr-50.gtr-uniform>* {
        padding-top: 0.75em;
    }
    .row {
        margin-top: 0;
        margin-left: -1.5em;
    }
    .row>* {
        padding: 0 0 0 1.5em;
    }
    .row.gtr-uniform {
        margin-top: -1.5em;
    }
    .row.gtr-uniform>* {
        padding-top: 1.5em;
    }
    .row.gtr-150 {
        margin-top: 0;
        margin-left: -2.25em;
    }
    .row.gtr-150>* {
        padding: 0 0 0 2.25em;
    }
    .row.gtr-150.gtr-uniform {
        margin-top: -2.25em;
    }
    .row.gtr-150.gtr-uniform>* {
        padding-top: 2.25em;
    }
    .row.gtr-200 {
        margin-top: 0;
        margin-left: -3em;
    }
    .row.gtr-200>* {
        padding: 0 0 0 3em;
    }
    .row.gtr-200.gtr-uniform {
        margin-top: -3em;
    }
    .row.gtr-200.gtr-uniform>* {
        padding-top: 3em;
    }
}

@media screen and (max-width: 980px) {
    .row {
        display: flex;
        flex-wrap: wrap;
        box-sizing: border-box;
        align-items: stretch;
    }
    .row>* {
        box-sizing: border-box;
    }
    .row.gtr-uniform>*> :last-child {
        margin-bottom: 0;
    }
    .row.aln-left {
        justify-content: flex-start;
    }
    .row.aln-center {
        justify-content: center;
    }
    .row.aln-right {
        justify-content: flex-end;
    }
    .row.aln-top {
        align-items: flex-start;
    }
    .row.aln-middle {
        align-items: center;
    }
    .row.aln-bottom {
        align-items: flex-end;
    }
    .row>.imp-medium {
        order: -1;
    }
    .row>.col-1-medium {
        width: 8.33333%;
    }
    .row>.off-1-medium {
        margin-left: 8.33333%;
    }
    .row>.col-2-medium {
        width: 16.66667%;
    }
    .row>.off-2-medium {
        margin-left: 16.66667%;
    }
    .row>.col-3-medium {
        width: 25%;
    }
    .row>.off-3-medium {
        margin-left: 25%;
    }
    .row>.col-4-medium {
        width: 33.33333%;
    }
    .row>.off-4-medium {
        margin-left: 33.33333%;
    }
    .row>.col-5-medium {
        width: 41.66667%;
    }
    .row>.off-5-medium {
        margin-left: 41.66667%;
    }
    .row>.col-6-medium {
        width: 50%;
    }
    .row>.off-6-medium {
        margin-left: 50%;
    }
    .row>.col-7-medium {
        width: 58.33333%;
    }
    .row>.off-7-medium {
        margin-left: 58.33333%;
    }
    .row>.col-8-medium {
        width: 66.66667%;
    }
    .row>.off-8-medium {
        margin-left: 66.66667%;
    }
    .row>.col-9-medium {
        width: 75%;
    }
    .row>.off-9-medium {
        margin-left: 75%;
    }
    .row>.col-10-medium {
        width: 83.33333%;
    }
    .row>.off-10-medium {
        margin-left: 83.33333%;
    }
    .row>.col-11-medium {
        width: 91.66667%;
    }
    .row>.off-11-medium {
        margin-left: 91.66667%;
    }
    .row>.col-12-medium {
        width: 100%;
    }
    .row>.off-12-medium {
        margin-left: 100%;
    }
    .row.gtr-0 {
        margin-top: 0;
        margin-left: 0em;
    }
    .row.gtr-0>* {
        padding: 0 0 0 0em;
    }
    .row.gtr-0.gtr-uniform {
        margin-top: 0em;
    }
    .row.gtr-0.gtr-uniform>* {
        padding-top: 0em;
    }
    .row.gtr-25 {
        margin-top: 0;
        margin-left: -0.375em;
    }
    .row.gtr-25>* {
        padding: 0 0 0 0.375em;
    }
    .row.gtr-25.gtr-uniform {
        margin-top: -0.375em;
    }
    .row.gtr-25.gtr-uniform>* {
        padding-top: 0.375em;
    }
    .row.gtr-50 {
        margin-top: 0;
        margin-left: -0.75em;
    }
    .row.gtr-50>* {
        padding: 0 0 0 0.75em;
    }
    .row.gtr-50.gtr-uniform {
        margin-top: -0.75em;
    }
    .row.gtr-50.gtr-uniform>* {
        padding-top: 0.75em;
    }
    .row {
        margin-top: 0;
        margin-left: -1.5em;
    }
    .row>* {
        padding: 0 0 0 1.5em;
    }
    .row.gtr-uniform {
        margin-top: -1.5em;
    }
    .row.gtr-uniform>* {
        padding-top: 1.5em;
    }
    .row.gtr-150 {
        margin-top: 0;
        margin-left: -2.25em;
    }
    .row.gtr-150>* {
        padding: 0 0 0 2.25em;
    }
    .row.gtr-150.gtr-uniform {
        margin-top: -2.25em;
    }
    .row.gtr-150.gtr-uniform>* {
        padding-top: 2.25em;
    }
    .row.gtr-200 {
        margin-top: 0;
        margin-left: -3em;
    }
    .row.gtr-200>* {
        padding: 0 0 0 3em;
    }
    .row.gtr-200.gtr-uniform {
        margin-top: -3em;
    }
    .row.gtr-200.gtr-uniform>* {
        padding-top: 3em;
    }
}

@media screen and (max-width: 736px) {
    .row {
        display: flex;
        flex-wrap: wrap;
        box-sizing: border-box;
        align-items: stretch;
    }
    .row>* {
        box-sizing: border-box;
    }
    .row.gtr-uniform>*> :last-child {
        margin-bottom: 0;
    }
    .row.aln-left {
        justify-content: flex-start;
    }
    .row.aln-center {
        justify-content: center;
    }
    .row.aln-right {
        justify-content: flex-end;
    }
    .row.aln-top {
        align-items: flex-start;
    }
    .row.aln-middle {
        align-items: center;
    }
    .row.aln-bottom {
        align-items: flex-end;
    }
    .row>.imp-small {
        order: -1;
    }
    .row>.col-1-small {
        width: 8.33333%;
    }
    .row>.off-1-small {
        margin-left: 8.33333%;
    }
    .row>.col-2-small {
        width: 16.66667%;
    }
    .row>.off-2-small {
        margin-left: 16.66667%;
    }
    .row>.col-3-small {
        width: 25%;
    }
    .row>.off-3-small {
        margin-left: 25%;
    }
    .row>.col-4-small {
        width: 33.33333%;
    }
    .row>.off-4-small {
        margin-left: 33.33333%;
    }
    .row>.col-5-small {
        width: 41.66667%;
    }
    .row>.off-5-small {
        margin-left: 41.66667%;
    }
    .row>.col-6-small {
        width: 50%;
    }
    .row>.off-6-small {
        margin-left: 50%;
    }
    .row>.col-7-small {
        width: 58.33333%;
    }
    .row>.off-7-small {
        margin-left: 58.33333%;
    }
    .row>.col-8-small {
        width: 66.66667%;
    }
    .row>.off-8-small {
        margin-left: 66.66667%;
    }
    .row>.col-9-small {
        width: 75%;
    }
    .row>.off-9-small {
        margin-left: 75%;
    }
    .row>.col-10-small {
        width: 83.33333%;
    }
    .row>.off-10-small {
        margin-left: 83.33333%;
    }
    .row>.col-11-small {
        width: 91.66667%;
    }
    .row>.off-11-small {
        margin-left: 91.66667%;
    }
    .row>.col-12-small {
        width: 100%;
    }
    .row>.off-12-small {
        margin-left: 100%;
    }
    .row.gtr-0 {
        margin-top: 0;
        margin-left: 0em;
    }
    .row.gtr-0>* {
        padding: 0 0 0 0em;
    }
    .row.gtr-0.gtr-uniform {
        margin-top: 0em;
    }
    .row.gtr-0.gtr-uniform>* {
        padding-top: 0em;
    }
    .row.gtr-25 {
        margin-top: 0;
        margin-left: -0.375em;
    }
    .row.gtr-25>* {
        padding: 0 0 0 0.375em;
    }
    .row.gtr-25.gtr-uniform {
        margin-top: -0.375em;
    }
    .row.gtr-25.gtr-uniform>* {
        padding-top: 0.375em;
    }
    .row.gtr-50 {
        margin-top: 0;
        margin-left: -0.75em;
    }
    .row.gtr-50>* {
        padding: 0 0 0 0.75em;
    }
    .row.gtr-50.gtr-uniform {
        margin-top: -0.75em;
    }
    .row.gtr-50.gtr-uniform>* {
        padding-top: 0.75em;
    }
    .row {
        margin-top: 0;
        margin-left: -1.5em;
    }
    .row>* {
        padding: 0 0 0 1.5em;
    }
    .row.gtr-uniform {
        margin-top: -1.5em;
    }
    .row.gtr-uniform>* {
        padding-top: 1.5em;
    }
    .row.gtr-150 {
        margin-top: 0;
        margin-left: -2.25em;
    }
    .row.gtr-150>* {
        padding: 0 0 0 2.25em;
    }
    .row.gtr-150.gtr-uniform {
        margin-top: -2.25em;
    }
    .row.gtr-150.gtr-uniform>* {
        padding-top: 2.25em;
    }
    .row.gtr-200 {
        margin-top: 0;
        margin-left: -3em;
    }
    .row.gtr-200>* {
        padding: 0 0 0 3em;
    }
    .row.gtr-200.gtr-uniform {
        margin-top: -3em;
    }
    .row.gtr-200.gtr-uniform>* {
        padding-top: 3em;
    }
}

@media screen and (max-width: 480px) {
    .row {
        display: flex;
        flex-wrap: wrap;
        box-sizing: border-box;
        align-items: stretch;
    }
    .row>* {
        box-sizing: border-box;
    }
    .row.gtr-uniform>*> :last-child {
        margin-bottom: 0;
    }
    .row.aln-left {
        justify-content: flex-start;
    }
    .row.aln-center {
        justify-content: center;
    }
    .row.aln-right {
        justify-content: flex-end;
    }
    .row.aln-top {
        align-items: flex-start;
    }
    .row.aln-middle {
        align-items: center;
    }
    .row.aln-bottom {
        align-items: flex-end;
    }
    .row>.imp-xsmall {
        order: -1;
    }
    .row>.col-1-xsmall {
        width: 8.33333%;
    }
    .row>.off-1-xsmall {
        margin-left: 8.33333%;
    }
    .row>.col-2-xsmall {
        width: 16.66667%;
    }
    .row>.off-2-xsmall {
        margin-left: 16.66667%;
    }
    .row>.col-3-xsmall {
        width: 25%;
    }
    .row>.off-3-xsmall {
        margin-left: 25%;
    }
    .row>.col-4-xsmall {
        width: 33.33333%;
    }
    .row>.off-4-xsmall {
        margin-left: 33.33333%;
    }
    .row>.col-5-xsmall {
        width: 41.66667%;
    }
    .row>.off-5-xsmall {
        margin-left: 41.66667%;
    }
    .row>.col-6-xsmall {
        width: 50%;
    }
    .row>.off-6-xsmall {
        margin-left: 50%;
    }
    .row>.col-7-xsmall {
        width: 58.33333%;
    }
    .row>.off-7-xsmall {
        margin-left: 58.33333%;
    }
    .row>.col-8-xsmall {
        width: 66.66667%;
    }
    .row>.off-8-xsmall {
        margin-left: 66.66667%;
    }
    .row>.col-9-xsmall {
        width: 75%;
    }
    .row>.off-9-xsmall {
        margin-left: 75%;
    }
    .row>.col-10-xsmall {
        width: 83.33333%;
    }
    .row>.off-10-xsmall {
        margin-left: 83.33333%;
    }
    .row>.col-11-xsmall {
        width: 91.66667%;
    }
    .row>.off-11-xsmall {
        margin-left: 91.66667%;
    }
    .row>.col-12-xsmall {
        width: 100%;
    }
    .row>.off-12-xsmall {
        margin-left: 100%;
    }
    .row.gtr-0 {
        margin-top: 0;
        margin-left: 0em;
    }
    .row.gtr-0>* {
        padding: 0 0 0 0em;
    }
    .row.gtr-0.gtr-uniform {
        margin-top: 0em;
    }
    .row.gtr-0.gtr-uniform>* {
        padding-top: 0em;
    }
    .row.gtr-25 {
        margin-top: 0;
        margin-left: -0.375em;
    }
    .row.gtr-25>* {
        padding: 0 0 0 0.375em;
    }
    .row.gtr-25.gtr-uniform {
        margin-top: -0.375em;
    }
    .row.gtr-25.gtr-uniform>* {
        padding-top: 0.375em;
    }
    .row.gtr-50 {
        margin-top: 0;
        margin-left: -0.75em;
    }
    .row.gtr-50>* {
        padding: 0 0 0 0.75em;
    }
    .row.gtr-50.gtr-uniform {
        margin-top: -0.75em;
    }
    .row.gtr-50.gtr-uniform>* {
        padding-top: 0.75em;
    }
    .row {
        margin-top: 0;
        margin-left: -1.5em;
    }
    .row>* {
        padding: 0 0 0 1.5em;
    }
    .row.gtr-uniform {
        margin-top: -1.5em;
    }
    .row.gtr-uniform>* {
        padding-top: 1.5em;
    }
    .row.gtr-150 {
        margin-top: 0;
        margin-left: -2.25em;
    }
    .row.gtr-150>* {
        padding: 0 0 0 2.25em;
    }
    .row.gtr-150.gtr-uniform {
        margin-top: -2.25em;
    }
    .row.gtr-150.gtr-uniform>* {
        padding-top: 2.25em;
    }
    .row.gtr-200 {
        margin-top: 0;
        margin-left: -3em;
    }
    .row.gtr-200>* {
        padding: 0 0 0 3em;
    }
    .row.gtr-200.gtr-uniform {
        margin-top: -3em;
    }
    .row.gtr-200.gtr-uniform>* {
        padding-top: 3em;
    }
}


/* Section/Article */

section.special,
article.special {
    text-align: center;
}

header p {
    color: white;
    position: relative;
    top: -0.25em;
}

header h3+p {
    font-size: 1.1em;
}

header h4+p,
header h5+p,
header h6+p {
    font-size: 0.9em;
}

header.major {
    margin: 0 0 3.5em 0;
}

header.major h2,
header.major h3,
header.major h4,
header.major h5,
header.major h6 {
    border-bottom: solid 2px #fff;
    display: inline-block;
    padding-bottom: 1em;
    position: relative;
}

header.major h2:after,
header.major h3:after,
header.major h4:after,
header.major h5:after,
header.major h6:after {
    content: '';
    display: block;
    height: 1px;
}

header.major p {
    color: #fff;
    top: 0;
}

@media screen and (max-width: 736px) {
    header.major {
        margin: 0 0 2em 0;
    }
}

@media screen and (max-width: 980px) {
    header br {
        display: none;
    }
}


/* Form */

form {
    margin: 0 0 2em 0;
}

label {
    color: #fff;
    display: block;
    font-size: 0.9em;
    font-weight: 600;
    margin: 0 0 1em 0;
}

input[type="text"],
input[type="password"],
input[type="email"],
select,
textarea {
    -moz-appearance: none;
    -webkit-appearance: none;
    -ms-appearance: none;
    appearance: none;
    background-color: rgba(214, 144, 144, 0.25);
    border-radius: 3px;
    border: none;
    color: inherit;
    display: block;
    outline: 0;
    padding: 0 1em;
    text-decoration: none;
    width: 100%;
}

input[type="text"]:invalid,
input[type="password"]:invalid,
input[type="email"]:invalid,
select:invalid,
textarea:invalid {
    box-shadow: none;
}

input[type="text"]:focus,
input[type="password"]:focus,
input[type="email"]:focus,
select:focus,
textarea:focus {
    box-shadow: 0 0 0 2px #21b2a6;
}

select {
    background-size: 1.25em;
    background-repeat: no-repeat;
    background-position: calc(100% - 1em) center;
    height: 2.75em;
    padding-right: 2.75em;
    text-overflow: ellipsis;
}

select:focus::-ms-value {
    background-color: transparent;
}

select::-ms-expand {
    display: none;
}

input[type="text"],
input[type="password"],
input[type="email"],
select {
    height: 2.75em;
}

textarea {
    padding: 0.75em 1em;
}

input[type="checkbox"],
input[type="radio"] {
    -moz-appearance: none;
    -webkit-appearance: none;
    -ms-appearance: none;
    appearance: none;
    display: block;
    float: left;
    margin-right: -2em;
    opacity: 0;
    width: 1em;
    z-index: -1;
}

input[type="checkbox"]+label,
input[type="radio"]+label {
    text-decoration: none;
    color: #fff;
    cursor: pointer;
    display: inline-block;
    font-size: 1em;
    font-weight: 400;
    padding-left: 2.4em;
    padding-right: 0.75em;
    position: relative;
}

input[type="checkbox"]+label:before,
input[type="radio"]+label:before {
    -moz-osx-font-smoothing: grayscale;
    -webkit-font-smoothing: antialiased;
    display: inline-block;
    font-style: normal;
    font-variant: normal;
    text-rendering: auto;
    line-height: 1;
    text-transform: none !important;
    font-family: 'Font Awesome 5 Free';
    font-weight: 900;
}

input[type="checkbox"]+label:before,
input[type="radio"]+label:before {
    background: rgba(144, 144, 144, 0.25);
    border-radius: 3px;
    content: '';
    display: inline-block;
    font-size: 0.8em;
    height: 2.0625em;
    left: 0;
    line-height: 2.0625em;
    position: absolute;
    text-align: center;
    top: 0;
    width: 2.0625em;
}

input[type="checkbox"]:checked+label:before,
input[type="radio"]:checked+label:before {
    background: #2e3842;
    color: #fff;
    content: '\f00c';
}

input[type="checkbox"]:focus+label:before,
input[type="radio"]:focus+label:before {
    box-shadow: 0 0 0 2px #21b2a6;
}

input[type="checkbox"]+label:before {
    border-radius: 3px;
}

input[type="radio"]+label:before {
    border-radius: 100%;
}

 ::-webkit-input-placeholder {
    color: rgba(255, 255, 255, 0.5) !important;
    opacity: 1.0;
}

 :-moz-placeholder {
    color: rgba(255, 255, 255, 0.5) !important;
    opacity: 1.0;
}

 ::-moz-placeholder {
    color: rgba(255, 255, 255, 0.5) !important;
    opacity: 1.0;
}

 :-ms-input-placeholder {
    color: rgba(255, 255, 255, 0.5) !important;
    opacity: 1.0;
}


/* Box */

.box {
    border-radius: 3px;
    border: solid 2px #fff;
    margin-bottom: 2em;
    padding: 1.5em;
}

.box> :last-child,
.box> :last-child> :last-child,
.box> :last-child> :last-child> :last-child {
    margin-bottom: 0;
}

.box.alt {
    border: 0;
    border-radius: 0;
    padding: 0;
}


/* Icon */

.icon {
    text-decoration: none;
    border-bottom: none;
    position: relative;
}

.icon:before {
    -moz-osx-font-smoothing: grayscale;
    -webkit-font-smoothing: antialiased;
    display: inline-block;
    font-style: normal;
    font-variant: normal;
    text-rendering: auto;
    line-height: 1;
    text-transform: none !important;
    font-family: 'Font Awesome 5 Free';
    font-weight: 400;
}

.icon>.label {
    display: none;
}

.icon:before {
    line-height: inherit;
}

.icon.solid:before {
    font-weight: 900;
}

.icon.brands:before {
    font-family: 'Font Awesome 5 Brands';
}

.icon.major {
    -moz-transform: rotate(-45deg);
    -webkit-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    transform: rotate(-45deg);
    border-radius: 3px;
    border: solid 2px #fff;
    display: inline-block;
    font-size: 1.35em;
    height: calc(3em + 2px);
    line-height: 3em;
    text-align: center;
    width: calc(3em + 2px);
}

.icon.major:before {
    -moz-transform: rotate(45deg);
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
    display: inline-block;
    font-size: 1.5em;
}

@media screen and (max-width: 736px) {
    .icon.major {
        font-size: 1em;
    }
}

.icon.style1 {
    color: #00ffcc;
}

.icon.style2 {
    color: #00f0ff;
}

.icon.style3 {
    color: #76ddff;
}


/* Image */

.image {
    border-radius: 3px;
    border: 0;
    display: inline-block;
    position: relative;
}

.image img {
    border-radius: 3px;
    display: block;
}

.image.left {
    float: left;
    margin: 0 2em 2em 0;
    top: 0.25em;
}

.image.right {
    float: right;
    margin: 0 0 2em 2em;
    top: 0.25em;
}

.image.left,
.image.right {
    max-width: 40%;
}

.image.left img,
.image.right img {
    width: 100%;
}

.image.fit {
    display: block;
    margin: 0 0 2em 0;
    width: 100%;
}

.image.fit img {
    width: 100%;
}


/* List */

ol {
    list-style: decimal;
    margin: 0 0 2em 0;
    padding-left: 1.25em;
}

ol li {
    padding-left: 0.25em;
}

ul {
    list-style: disc;
    margin: 0 0 2em 0;
    padding-left: 1em;
}

ul li {
    padding-left: 0.5em;
}

ul.alt {
    list-style: none;
    padding-left: 0;
}

ul.alt li {
    border-top: solid 1px #fff;
    padding: 0.5em 0;
}

ul.alt li:first-child {
    border-top: 0;
    padding-top: 0;
}

dl {
    margin: 0 0 2em 0;
}


/* Actions */

ul.actions {
    display: -moz-flex;
    display: -webkit-flex;
    display: -ms-flex;
    display: flex;
    cursor: default;
    list-style: none;
    margin-left: -1em;
    padding-left: 0;
}

ul.actions li {
    padding: 0 0 0 1em;
    vertical-align: middle;
}

ul.actions.special {
    -moz-justify-content: center;
    -webkit-justify-content: center;
    -ms-justify-content: center;
    justify-content: center;
    width: 100%;
    margin-left: 0;
}

ul.actions.special li:first-child {
    padding-left: 0;
}

ul.actions.stacked {
    -moz-flex-direction: column;
    -webkit-flex-direction: column;
    -ms-flex-direction: column;
    flex-direction: column;
    margin-left: 0;
}

ul.actions.stacked li {
    padding: 1em 0 0 0;
}

ul.actions.stacked li:first-child {
    padding-top: 0;
}

ul.actions.fit {
    width: calc(100% + 1em);
}

ul.actions.fit li {
    -moz-flex-grow: 1;
    -webkit-flex-grow: 1;
    -ms-flex-grow: 1;
    flex-grow: 1;
    -moz-flex-shrink: 1;
    -webkit-flex-shrink: 1;
    -ms-flex-shrink: 1;
    flex-shrink: 1;
    width: 100%;
}

ul.actions.fit li>* {
    width: 100%;
}

ul.actions.fit.stacked {
    width: 100%;
}

@media screen and (max-width: 480px) {
    ul.actions:not(.fixed) {
        -moz-flex-direction: column;
        -webkit-flex-direction: column;
        -ms-flex-direction: column;
        flex-direction: column;
        margin-left: 0;
        width: 100% !important;
    }
    ul.actions:not(.fixed) li {
        -moz-flex-grow: 1;
        -webkit-flex-grow: 1;
        -ms-flex-grow: 1;
        flex-grow: 1;
        -moz-flex-shrink: 1;
        -webkit-flex-shrink: 1;
        -ms-flex-shrink: 1;
        flex-shrink: 1;
        padding: 1em 0 0 0;
        text-align: center;
        width: 100%;
    }
    ul.actions:not(.fixed) li>* {
        width: 100%;
    }
    ul.actions:not(.fixed) li:first-child {
        padding-top: 0;
    }
    ul.actions:not(.fixed) li input[type="submit"],
    ul.actions:not(.fixed) li input[type="reset"],
    ul.actions:not(.fixed) li input[type="button"],
    ul.actions:not(.fixed) li button,
    ul.actions:not(.fixed) li .button {
        width: 100%;
    }
    ul.actions:not(.fixed) li input[type="submit"].icon:before,
    ul.actions:not(.fixed) li input[type="reset"].icon:before,
    ul.actions:not(.fixed) li input[type="button"].icon:before,
    ul.actions:not(.fixed) li button.icon:before,
    ul.actions:not(.fixed) li .button.icon:before {
        margin-left: -0.5em;
    }
}


/* Icons */

ul.icons {
    cursor: default;
    list-style: none;
    padding-left: 0;
}

ul.icons li {
    display: inline-block;
    padding: 0 1em 0 0;
}

ul.icons li:last-child {
    padding-right: 0 !important;
}

ul.icons.major {
    padding: 1em 0;
}

ul.icons.major li {
    padding-right: 3.5em;
}

@media screen and (max-width: 736px) {
    ul.icons.major li {
        padding: 0 1em !important;
    }
}


/* Table */

.table-wrapper {
    -webkit-overflow-scrolling: touch;
    overflow-x: auto;
}

table {
    margin: 0 0 2em 0;
    width: 100%;
}

table tbody tr {
    border: solid 1px #fff;
    border-left: 0;
    border-right: 0;
}

table tbody tr:nth-child(2n+1) {
    background-color: rgba(144, 144, 144, 0.25);
}

table td {
    padding: 0.75em 0.75em;
}

table th {
    color: #fff;
    font-size: 0.9em;
    font-weight: 600;
    padding: 0 0.75em 0.75em 0.75em;
    text-align: left;
}

table thead {
    border-bottom: solid 2px #fff;
}

table tfoot {
    border-top: solid 2px #fff;
}

table.alt {
    border-collapse: separate;
}

table.alt tbody tr td {
    border: solid 1px #fff;
    border-left-width: 0;
    border-top-width: 0;
}

table.alt tbody tr td:first-child {
    border-left-width: 1px;
}

table.alt tbody tr:first-child td {
    border-top-width: 1px;
}

table.alt thead {
    border-bottom: 0;
}

table.alt tfoot {
    border-top: 0;
}


/* Button */

input[type="submit"],
input[type="reset"],
input[type="button"],
button,
.button {
    -moz-appearance: none;
    -webkit-appearance: none;
    -ms-appearance: none;
    appearance: none;
    -moz-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
    -webkit-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
    -ms-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
    transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
    background-color: transparent;
    border-radius: 3px;
    border: 0;
    box-shadow: inset 0 0 0 2px black;
    color: black;
    cursor: pointer;
    display: inline-block;
    font-size: 0.8em;
    font-weight: 600;
    height: 3.125em;
    letter-spacing: 0.225em;
    line-height: 3.125em;
    max-width: 30em;
    padding: 0 2.75em;
    text-align: center;
    text-decoration: none;
    text-transform: uppercase;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

input[type="submit"]:hover,
input[type="reset"]:hover,
input[type="button"]:hover,
button:hover,
.button:hover {
    background-color: rgba(144, 144, 144, 0.25);
}

input[type="submit"]:active,
input[type="reset"]:active,
input[type="button"]:active,
button:active,
.button:active {
    background-color: rgba(144, 144, 144, 0.5);
}

input[type="submit"].icon:before,
input[type="reset"].icon:before,
input[type="button"].icon:before,
button.icon:before,
.button.icon:before {
    margin-right: 0.5em;
}

input[type="submit"].fit,
input[type="reset"].fit,
input[type="button"].fit,
button.fit,
.button.fit {
    width: 100%;
}

input[type="submit"].small,
input[type="reset"].small,
input[type="button"].small,
button.small,
.button.small {
    font-size: 0.8em;
}

input[type="submit"].large,
input[type="reset"].large,
input[type="button"].large,
button.large,
.button.large {
    font-size: 1.35em;
}

input[type="submit"].primary,
input[type="reset"].primary,
input[type="button"].primary,
button.primary,
.button.primary {
    background-color: #ed4933;
    box-shadow: none !important;
    color: #ffffff !important;
}

input[type="submit"].primary:hover,
input[type="reset"].primary:hover,
input[type="button"].primary:hover,
button.primary:hover,
.button.primary:hover {
    background-color: #ef5e4a !important;
}

input[type="submit"].primary:active,
input[type="reset"].primary:active,
input[type="button"].primary:active,
button.primary:active,
.button.primary:active {
    background-color: #eb341c !important;
}

input[type="submit"].disabled,
input[type="submit"]:disabled,
input[type="reset"].disabled,
input[type="reset"]:disabled,
input[type="button"].disabled,
input[type="button"]:disabled,
button.disabled,
button:disabled,
.button.disabled,
.button:disabled {
    pointer-events: none;
    opacity: 0.25;
}

@media screen and (max-width: 736px) {
    input[type="submit"],
    input[type="reset"],
    input[type="button"],
    button,
    .button {
        height: 3.75em;
        line-height: 3.75em;
    }
}


/* Features */

.features {
    display: -moz-flex;
    display: -webkit-flex;
    display: -ms-flex;
    display: flex;
    -moz-flex-wrap: wrap;
    -webkit-flex-wrap: wrap;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    -moz-justify-content: center;
    -webkit-justify-content: center;
    -ms-justify-content: center;
    justify-content: center;
    list-style: none;
    padding: 0;
    width: 100%;
}

.features li {
    padding: 4em 4em 2em 6em;
    display: block;
    position: relative;
    text-align: left;
    width: 50%;
}

.features li:nth-child(1) {
    background-color: rgba(0, 0, 0, 0.035);
}

.features li:nth-child(2) {
    background-color: rgba(0, 0, 0, 0.07);
}

.features li:nth-child(3) {
    background-color: rgba(0, 0, 0, 0.105);
}

.features li:nth-child(4) {
    background-color: rgba(0, 0, 0, 0.14);
}

.features li:nth-child(5) {
    background-color: rgba(0, 0, 0, 0.175);
}

.features li:nth-child(6) {
    background-color: rgba(0, 0, 0, 0.21);
}

.features li:nth-child(7) {
    background-color: rgba(0, 0, 0, 0.245);
}

.features li:nth-child(8) {
    background-color: rgba(0, 0, 0, 0.28);
}

.features li:nth-child(9) {
    background-color: rgba(0, 0, 0, 0.315);
}

.features li:nth-child(10) {
    background-color: rgba(0, 0, 0, 0.35);
}

.features li:before {
    display: block;
    color: #00ffcc;
    position: absolute;
    left: 1.75em;
    top: 2.75em;
    font-size: 1.5em;
}

.features li:nth-child(1) {
    border-top-left-radius: 3px;
}

.features li:nth-child(2) {
    border-top-right-radius: 3px;
}

.features li:nth-last-child(1) {
    border-bottom-right-radius: 3px;
}

.features li:nth-last-child(2) {
    border-bottom-left-radius: 3px;
}

@media screen and (max-width: 980px) {
    .features li {
        padding: 3em 2em 1em 2em;
        text-align: center;
    }
    .features li:before {
        left: 0;
        margin: 0 0 1em 0;
        position: relative;
        top: 0;
    }
}

@media screen and (max-width: 736px) {
    .features li {
        padding: 3em 0 1em 0;
        background-color: transparent !important;
        border-top: solid 2px #fff;
        width: 100%;
    }
    .features li:first-child {
        border-top: 0;
    }
}


/* Spotlight */

.spotlight {
    -moz-align-items: center;
    -webkit-align-items: center;
    -ms-align-items: center;
    align-items: center;
    display: -moz-flex;
    display: -webkit-flex;
    display: -ms-flex;
    display: flex;
}

.spotlight .image {
    -moz-order: 1;
    -webkit-order: 1;
    -ms-order: 1;
    order: 1;
    border-radius: 0;
    width: 40%;
}

.spotlight .image img {
    border-radius: 0;
    width: 100%;
}

.spotlight .content {
    padding: 2em 4em 0.1em 4em;
    -moz-order: 2;
    -webkit-order: 2;
    -ms-order: 2;
    order: 2;
    max-width: 48em;
    width: 60%;
}

.spotlight:nth-child(2n) {
    -moz-flex-direction: row-reverse;
    -webkit-flex-direction: row-reverse;
    -ms-flex-direction: row-reverse;
    flex-direction: row-reverse;
}

.spotlight:nth-child(1) {
    background-color: rgba(0, 0, 0, 0.075);
}

.spotlight:nth-child(2) {
    background-color: rgba(0, 0, 0, 0.15);
}

.spotlight:nth-child(3) {
    background-color: rgba(0, 0, 0, 0.225);
}

.spotlight:nth-child(4) {
    background-color: rgba(0, 0, 0, 0.3);
}

.spotlight:nth-child(5) {
    background-color: rgba(0, 0, 0, 0.375);
}

.spotlight:nth-child(6) {
    background-color: rgba(0, 0, 0, 0.45);
}

.spotlight:nth-child(7) {
    background-color: rgba(0, 0, 0, 0.525);
}

.spotlight:nth-child(8) {
    background-color: rgba(0, 0, 0, 0.6);
}

.spotlight:nth-child(9) {
    background-color: rgba(0, 0, 0, 0.675);
}

.spotlight:nth-child(10) {
    background-color: rgba(0, 0, 0, 0.75);
}

@media screen and (max-width: 1280px) {
    .spotlight .image {
        width: 45%;
    }
    .spotlight .content {
        width: 55%;
    }
}

@media screen and (max-width: 980px) {
    .spotlight {
        display: block;
    }
    .spotlight br {
        display: none;
    }
    .spotlight .image {
        width: 100%;
    }
    .spotlight .content {
        padding: 4em 3em 2em 3em;
        max-width: none;
        text-align: center;
        width: 100%;
    }
}

@media screen and (max-width: 736px) {
    .spotlight .content {
        padding: 3em 2em 1em 2em;
    }
}


/* Wrapper */

img {
    height: 40vh;
    max-width: 18vw;
    min-width: 300px;
}

.wrapper {
    padding: 6em 0 4em 0;
    -webkit-user-select:none;
    -moz-user-select:none;
    -ms-user-select:none;
    user-select:none
}

.wrapper img {
  -webkit-user-drag: none;
}

.wrapper>.inner {
    width: 60em;
    margin: 0 auto;
}

@media screen and (max-width: 1280px) {
    .wrapper>.inner {
        width: 90%;
    }
}

@media screen and (max-width: 980px) {
    .wrapper>.inner {
        width: 100%;
    }
}

.wrapper a {
  color: white;
}
.wrapper a:hover {
  color: #557571;
}

.wrapper.alt {
    padding: 0;
}

.wrapper.style1 {
    background-color: #21b2a6;
    color: #c8ece9;
}

.wrapper.style1 strong,
.wrapper.style1 b {
    color: #ffffff;
}

.wrapper.style1 h2,
.wrapper.style1 h3,
.wrapper.style1 h4,
.wrapper.style1 h5,
.wrapper.style1 h6 {
    color: #ffffff;
}

.wrapper.style1 hr {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 blockquote {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 code {
    background: rgba(255, 255, 255, 0.075);
}

.wrapper.style1 header p {
    color: #a6e0db;
}

.wrapper.style1 header.major h2,
.wrapper.style1 header.major h3,
.wrapper.style1 header.major h4,
.wrapper.style1 header.major h5,
.wrapper.style1 header.major h6 {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 header.major p {
    color: #c8ece9;
}

.wrapper.style1 label {
    color: #ffffff;
}

.wrapper.style1 input[type="text"],
.wrapper.style1 input[type="password"],
.wrapper.style1 input[type="email"],
.wrapper.style1 select,
.wrapper.style1 textarea {
    background-color: rgba(255, 255, 255, 0.075);
}

.wrapper.style1 select {
    /* background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='40' height='40' preserveAspectRatio='none' viewBox='0 0 40 40'%3E%3Cpath d='M9.4,12.3l10.4,10.4l10.4-10.4c0.2-0.2,0.5-0.4,0.9-0.4c0.3,0,0.6,0.1,0.9,0.4l3.3,3.3c0.2,0.2,0.4,0.5,0.4,0.9 c0,0.4-0.1,0.6-0.4,0.9L20.7,31.9c-0.2,0.2-0.5,0.4-0.9,0.4c-0.3,0-0.6-0.1-0.9-0.4L4.3,17.3c-0.2-0.2-0.4-0.5-0.4-0.9 c0-0.4,0.1-0.6,0.4-0.9l3.3-3.3c0.2-0.2,0.5-0.4,0.9-0.4S9.1,12.1,9.4,12.3z' fill='rgba(0, 0, 0, 0.125)' /%3E%3C/svg%3E"); */
}

.wrapper.style1 select option {
    color: #ffffff;
    background: #21b2a6;
}

.wrapper.style1 input[type="checkbox"]+label,
.wrapper.style1 input[type="radio"]+label {
    color: #c8ece9;
}

.wrapper.style1 input[type="checkbox"]+label:before,
.wrapper.style1 input[type="radio"]+label:before {
    background: rgba(255, 255, 255, 0.075);
}

.wrapper.style1 input[type="checkbox"]:checked+label:before,
.wrapper.style1 input[type="radio"]:checked+label:before {
    background: #ffffff;
    color: #21b2a6;
}

.wrapper.style1 ::-webkit-input-placeholder {
    color: #a6e0db !important;
}

.wrapper.style1 :-moz-placeholder {
    color: #a6e0db !important;
}

.wrapper.style1 ::-moz-placeholder {
    color: #a6e0db !important;
}

.wrapper.style1 :-ms-input-placeholder {
    color: #a6e0db !important;
}

.wrapper.style1 .formerize-placeholder {
    color: #a6e0db !important;
}

.wrapper.style1 .icon.major {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 ul.alt li {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 table tbody tr {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 table tbody tr:nth-child(2n+1) {
    background-color: rgba(255, 255, 255, 0.075);
}

.wrapper.style1 table th {
    color: #ffffff;
}

.wrapper.style1 table thead {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 table tfoot {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 table.alt tbody tr td {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style1 input[type="submit"],
.wrapper.style1 input[type="reset"],
.wrapper.style1 input[type="button"],
.wrapper.style1 button,
.wrapper.style1 .button {
    box-shadow: inset 0 0 0 2px rgba(0, 0, 0, 0.125);
    color: #ffffff;
}

.wrapper.style1 input[type="submit"]:hover,
.wrapper.style1 input[type="reset"]:hover,
.wrapper.style1 input[type="button"]:hover,
.wrapper.style1 button:hover,
.wrapper.style1 .button:hover {
    background-color: rgba(255, 255, 255, 0.075);
}

.wrapper.style1 input[type="submit"]:active,
.wrapper.style1 input[type="reset"]:active,
.wrapper.style1 input[type="button"]:active,
.wrapper.style1 button:active,
.wrapper.style1 .button:active {
    background-color: rgba(255, 255, 255, 0.2);
}

@media screen and (max-width: 736px) {
    .wrapper.style1 .features li {
        border-top-color: rgba(0, 0, 0, 0.125);
    }
}

.wrapper.style2 {
    background-color: rgba(251, 249, 241);
}

.wrapper.style3 {
    background-color: #505393;
    color: #d3d4e4;
}

.wrapper.style3 strong,
.wrapper.style3 b {
    color: #ffffff;
}

.wrapper.style3 h2,
.wrapper.style3 h3,
.wrapper.style3 h4,
.wrapper.style3 h5,
.wrapper.style3 h6 {
    color: #ffffff;
}

.wrapper.style3 hr {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 blockquote {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 code {
    background: rgba(255, 255, 255, 0.075);
}

.wrapper.style3 header p {
    color: #b9bad4;
}

.wrapper.style3 header.major h2,
.wrapper.style3 header.major h3,
.wrapper.style3 header.major h4,
.wrapper.style3 header.major h5,
.wrapper.style3 header.major h6 {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 header.major p {
    color: #d3d4e4;
}

.wrapper.style3 label {
    color: #ffffff;
}

.wrapper.style3 input[type="text"],
.wrapper.style3 input[type="password"],
.wrapper.style3 input[type="email"],
.wrapper.style3 select,
.wrapper.style3 textarea {
    background-color: rgba(255, 255, 255, 0.075);
}

.wrapper.style3 select {
    /* background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='40' height='40' preserveAspectRatio='none' viewBox='0 0 40 40'%3E%3Cpath d='M9.4,12.3l10.4,10.4l10.4-10.4c0.2-0.2,0.5-0.4,0.9-0.4c0.3,0,0.6,0.1,0.9,0.4l3.3,3.3c0.2,0.2,0.4,0.5,0.4,0.9 c0,0.4-0.1,0.6-0.4,0.9L20.7,31.9c-0.2,0.2-0.5,0.4-0.9,0.4c-0.3,0-0.6-0.1-0.9-0.4L4.3,17.3c-0.2-0.2-0.4-0.5-0.4-0.9 c0-0.4,0.1-0.6,0.4-0.9l3.3-3.3c0.2-0.2,0.5-0.4,0.9-0.4S9.1,12.1,9.4,12.3z' fill='rgba(0, 0, 0, 0.125)' /%3E%3C/svg%3E"); */
}

.wrapper.style3 select option {
    color: #ffffff;
    background: #505393;
}

.wrapper.style3 input[type="checkbox"]+label,
.wrapper.style3 input[type="radio"]+label {
    color: #d3d4e4;
}

.wrapper.style3 input[type="checkbox"]+label:before,
.wrapper.style3 input[type="radio"]+label:before {
    background: rgba(255, 255, 255, 0.075);
}

.wrapper.style3 input[type="checkbox"]:checked+label:before,
.wrapper.style3 input[type="radio"]:checked+label:before {
    background: #ffffff;
    color: #505393;
}

.wrapper.style3 ::-webkit-input-placeholder {
    color: #b9bad4 !important;
}

.wrapper.style3 :-moz-placeholder {
    color: #b9bad4 !important;
}

.wrapper.style3 ::-moz-placeholder {
    color: #b9bad4 !important;
}

.wrapper.style3 :-ms-input-placeholder {
    color: #b9bad4 !important;
}

.wrapper.style3 .formerize-placeholder {
    color: #b9bad4 !important;
}

.wrapper.style3 .icon.major {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 ul.alt li {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 table tbody tr {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 table tbody tr:nth-child(2n+1) {
    background-color: rgba(255, 255, 255, 0.075);
}

.wrapper.style3 table th {
    color: #ffffff;
}

.wrapper.style3 table thead {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 table tfoot {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 table.alt tbody tr td {
    border-color: rgba(0, 0, 0, 0.125);
}

.wrapper.style3 input[type="submit"],
.wrapper.style3 input[type="reset"],
.wrapper.style3 input[type="button"],
.wrapper.style3 button,
.wrapper.style3 .button {
    box-shadow: inset 0 0 0 2px rgba(0, 0, 0, 0.125);
    color: #ffffff;
}

.wrapper.style3 input[type="submit"]:hover,
.wrapper.style3 input[type="reset"]:hover,
.wrapper.style3 input[type="button"]:hover,
.wrapper.style3 button:hover,
.wrapper.style3 .button:hover {
    background-color: rgba(255, 255, 255, 0.075);
}

.wrapper.style3 input[type="submit"]:active,
.wrapper.style3 input[type="reset"]:active,
.wrapper.style3 input[type="button"]:active,
.wrapper.style3 button:active,
.wrapper.style3 .button:active {
    background-color: rgba(255, 255, 255, 0.2);
}

@media screen and (max-width: 736px) {
    .wrapper.style3 .features li {
        border-top-color: rgba(0, 0, 0, 0.125);
    }
}

.wrapper.style4 {
    background-color: transparent;
}

.wrapper.style5 {
    background-color: #ffffff;
    color: #4E4852;
}

.wrapper.style5 strong,
.wrapper.style5 b {
    color: #2E3842;
}

.wrapper.style5 h2,
.wrapper.style5 h3,
.wrapper.style5 h4,
.wrapper.style5 h5,
.wrapper.style5 h6 {
    color: #2E3842;
}

.wrapper.style5 img {
    max-width: 30vw;
    max-height: 30vh;
}

.wrapper.style5 hr {
    border-color: #dfdfdf;
}

.wrapper.style5 blockquote {
    border-color: #dfdfdf;
}

.wrapper.style5 code {
    background: rgba(0, 0, 0, 0.0375);
}

.wrapper.style5 header p {
    color: #8E8892;
}

.wrapper.style5 header.major h2,
.wrapper.style5 header.major h3,
.wrapper.style5 header.major h4,
.wrapper.style5 header.major h5,
.wrapper.style5 header.major h6 {
    border-color: #dfdfdf;
}

.wrapper.style5 header.major p {
    color: #4E4852;
}

.wrapper.style5 label {
    color: #2E3842;
}

.wrapper.style5 input[type="text"],
.wrapper.style5 input[type="password"],
.wrapper.style5 input[type="email"],
.wrapper.style5 select,
.wrapper.style5 textarea {
    background-color: rgba(0, 0, 0, 0.0375);
}

.wrapper.style5 select {
    /* background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='40' height='40' preserveAspectRatio='none' viewBox='0 0 40 40'%3E%3Cpath d='M9.4,12.3l10.4,10.4l10.4-10.4c0.2-0.2,0.5-0.4,0.9-0.4c0.3,0,0.6,0.1,0.9,0.4l3.3,3.3c0.2,0.2,0.4,0.5,0.4,0.9 c0,0.4-0.1,0.6-0.4,0.9L20.7,31.9c-0.2,0.2-0.5,0.4-0.9,0.4c-0.3,0-0.6-0.1-0.9-0.4L4.3,17.3c-0.2-0.2-0.4-0.5-0.4-0.9 c0-0.4,0.1-0.6,0.4-0.9l3.3-3.3c0.2-0.2,0.5-0.4,0.9-0.4S9.1,12.1,9.4,12.3z' fill='%23dfdfdf' /%3E%3C/svg%3E"); */
}

.wrapper.style5 select option {
    color: #2E3842;
    background: #ffffff;
}

.wrapper.style5 input[type="checkbox"]+label,
.wrapper.style5 input[type="radio"]+label {
    color: #4E4852;
}

.wrapper.style5 input[type="checkbox"]+label:before,
.wrapper.style5 input[type="radio"]+label:before {
    background: rgba(0, 0, 0, 0.0375);
}

.wrapper.style5 input[type="checkbox"]:checked+label:before,
.wrapper.style5 input[type="radio"]:checked+label:before {
    background: #2E3842;
    color: #ffffff;
}

.wrapper.style5 ::-webkit-input-placeholder {
    color: #8E8892 !important;
}

.wrapper.style5 :-moz-placeholder {
    color: #8E8892 !important;
}

.wrapper.style5 ::-moz-placeholder {
    color: #8E8892 !important;
}

.wrapper.style5 :-ms-input-placeholder {
    color: #8E8892 !important;
}

.wrapper.style5 .formerize-placeholder {
    color: #8E8892 !important;
}

.wrapper.style5 .icon.major {
    border-color: #dfdfdf;
}

.wrapper.style5 ul.alt li {
    border-color: #dfdfdf;
}

.wrapper.style5 table tbody tr {
    border-color: #dfdfdf;
}

.wrapper.style5 table tbody tr:nth-child(2n+1) {
    background-color: rgba(0, 0, 0, 0.0375);
}

.wrapper.style5 table th {
    color: #2E3842;
}

.wrapper.style5 table thead {
    border-color: #dfdfdf;
}

.wrapper.style5 table tfoot {
    border-color: #dfdfdf;
}

.wrapper.style5 table.alt tbody tr td {
    border-color: #dfdfdf;
}

.wrapper.style5 input[type="submit"],
.wrapper.style5 input[type="reset"],
.wrapper.style5 input[type="button"],
.wrapper.style5 button,
.wrapper.style5 .button {
    box-shadow: inset 0 0 0 2px #dfdfdf;
    color: #2E3842;
}

.wrapper.style5 input[type="submit"]:hover,
.wrapper.style5 input[type="reset"]:hover,
.wrapper.style5 input[type="button"]:hover,
.wrapper.style5 button:hover,
.wrapper.style5 .button:hover {
    background-color: rgba(0, 0, 0, 0.0375);
}

.wrapper.style5 input[type="submit"]:active,
.wrapper.style5 input[type="reset"]:active,
.wrapper.style5 input[type="button"]:active,
.wrapper.style5 button:active,
.wrapper.style5 .button:active {
    background-color: rgba(0, 0, 0, 0.1);
}

@media screen and (max-width: 736px) {
    .wrapper.style5 .features li {
        border-top-color: #dfdfdf;
    }
}

@media screen and (max-width: 980px) {
    .wrapper {
        padding: 4em 3em 2em 3em;
    }
}

@media screen and (max-width: 736px) {
    .wrapper {
        padding: 3em 2em 1em 2em;
    }
}


/* Page Wrapper + Menu */

#page-wrapper {
    -moz-transition: opacity 0.5s ease;
    -webkit-transition: opacity 0.5s ease;
    -ms-transition: opacity 0.5s ease;
    transition: opacity 0.5s ease;
    opacity: 1;
    padding-top: 3em;
}

#page-wrapper:before {
    background: rgba(0, 0, 0, 0);
    content: '';
    display: block;
    display: none;
    height: 100%;
    left: 0;
    position: fixed;
    top: 0;
    width: 100%;
    z-index: 10001;
}

#menu {
    -moz-transform: translateX(20em);
    -webkit-transform: translateX(20em);
    -ms-transform: translateX(20em);
    transform: translateX(20em);
    -moz-transition: -moz-transform 0.5s ease;
    -webkit-transition: -webkit-transform 0.5s ease;
    -ms-transition: -ms-transform 0.5s ease;
    transition: transform 0.5s ease;
    -webkit-overflow-scrolling: touch;
    background: #21b2a6;
    color: #ffffff;
    height: 100%;
    max-width: 80%;
    overflow-y: auto;
    padding: 3em 2em;
    position: fixed;
    right: 0;
    top: 0;
    width: 20em;
    z-index: 10002;
}

#menu ul {
    list-style: none;
    padding: 0;
}

#menu ul>li {
    border-top: solid 1px rgba(0, 0, 0, 0.125);
    margin: 0.5em 0 0 0;
    padding: 0.5em 0 0 0;
}

#menu ul>li:first-child {
    border-top: 0 !important;
    margin-top: 0 !important;
    padding-top: 0 !important;
}

#menu ul>li>a {
    border: 0;
    color: inherit;
    display: block;
    font-size: 0.8em;
    letter-spacing: 0.225em;
    outline: 0;
    text-decoration: none;
    text-transform: uppercase;
}

@media screen and (max-width: 736px) {
    #menu ul>li>a {
        line-height: 3em;
    }
}

#menu .close {
    /* background-image: url("images/close.svg"); */
    background-position: 4.85em 1em;
    background-repeat: no-repeat;
    border: 0;
    cursor: pointer;
    display: block;
    height: 3em;
    position: absolute;
    right: 0;
    top: 0;
    vertical-align: middle;
    width: 7em;
}

@media screen and (max-width: 736px) {
    #menu {
        padding: 3em 1.5em;
    }
}

body.is-menu-visible #page-wrapper {
    opacity: 0.35;
}

body.is-menu-visible #page-wrapper:before {
    display: block;
}

body.is-menu-visible #menu {
    -moz-transform: translateX(0);
    -webkit-transform: translateX(0);
    -ms-transform: translateX(0);
    transform: translateX(0);
}


/* Header */

#header {
    -moz-transition: background-color 0.2s ease;
    -webkit-transition: background-color 0.2s ease;
    -ms-transition: background-color 0.2s ease;
    transition: background-color 0.2s ease;
    background: #2e3842;
    height: 3em;
    left: 0;
    line-height: 3em;
    position: fixed;
    top: 0;
    width: 100%;
    z-index: 10000;
}

#header h1 {
    -moz-transition: opacity 0.2s ease;
    -webkit-transition: opacity 0.2s ease;
    -ms-transition: opacity 0.2s ease;
    transition: opacity 0.2s ease;
    height: inherit;
    left: 1.25em;
    line-height: inherit;
    position: absolute;
    top: 0;
}

#header h1 a {
    border: 0;
    display: block;
    height: inherit;
    line-height: inherit;
}

@media screen and (max-width: 736px) {
    #header h1 a {
        font-size: 0.8em;
    }
}

#header nav {
    height: inherit;
    line-height: inherit;
    position: absolute;
    right: 0;
    top: 0;
}

#header nav>ul {
    list-style: none;
    margin: 0;
    padding: 0;
    white-space: nowrap;
}

#header nav>ul>li {
    display: inline-block;
    padding: 0;
}

#header nav>ul>li>a {
    border: 0;
    color: #fff;
    display: block;
    font-size: 0.8em;
    letter-spacing: 0.225em;
    padding: 0 1.5em;
    text-transform: uppercase;
}

#header nav>ul>li>a.menuToggle {
    outline: 0;
    position: relative;
}

#header nav>ul>li>a.menuToggle:after {
    /* background-image: url("images/bars.svg"); */
    background-position: right center;
    background-repeat: no-repeat;
    content: '';
    display: inline-block;
    height: 3.75em;
    vertical-align: top;
    width: 2em;
}

@media screen and (max-width: 736px) {
    #header nav>ul>li>a.menuToggle {
        padding: 0 1.5em;
    }
    #header nav>ul>li>a.menuToggle span {
        display: none;
    }
}

@media screen and (max-width: 736px) {
    #header nav>ul>li>a {
        padding: 0 0 0 1.5em;
    }
}

#header nav>ul>li:first-child {
    margin-left: 0;
}

#header.alt {
    background: transparent;
}

#header.alt h1 {
    pointer-events: none;
    opacity: 0;
}


/* Banner */

#banner {
    display: -moz-flex;
    display: -webkit-flex;
    display: -ms-flex;
    display: flex;
    -moz-flex-direction: column;
    -webkit-flex-direction: column;
    -ms-flex-direction: column;
    flex-direction: column;
    -moz-justify-content: center;
    -webkit-justify-content: center;
    -ms-justify-content: center;
    justify-content: center;
    cursor: default;
    height: 100vh;
    min-height: 35em;
    overflow: hidden;
    position: relative;
    text-align: center;
}

#banner h2 {
    -moz-transform: scale(1);
    -webkit-transform: scale(1);
    -ms-transform: scale(1);
    transform: scale(1);
    -moz-transition: -moz-transform 0.5s ease, opacity 0.5s ease;
    -webkit-transition: -webkit-transform 0.5s ease, opacity 0.5s ease;
    -ms-transition: -ms-transform 0.5s ease, opacity 0.5s ease;
    transition: transform 0.5s ease, opacity 0.5s ease;
    display: inline-block;
    font-size: 1.75em;
    opacity: 1;
    padding: 0.35em 1em;
    position: relative;
    z-index: 1;
}

#banner h2:before,
#banner h2:after {
    -moz-transition: width 0.85s ease;
    -webkit-transition: width 0.85s ease;
    -ms-transition: width 0.85s ease;
    transition: width 0.85s ease;
    -moz-transition-delay: 0.25s;
    -webkit-transition-delay: 0.25s;
    -ms-transition-delay: 0.25s;
    transition-delay: 0.25s;
    background: #fff;
    content: '';
    display: block;
    height: 2px;
    position: absolute;
    width: 100%;
}

#banner h2:before {
    top: 0;
    left: 0;
}

#banner h2:after {
    bottom: 0;
    right: 0;
}

#banner p {
    letter-spacing: 0.225em;
    text-transform: uppercase;
}

#banner p a {
    color: inherit;
}

#banner .more {
    -moz-transition: -moz-transform 0.75s ease, opacity 0.75s ease;
    -webkit-transition: -webkit-transform 0.75s ease, opacity 0.75s ease;
    -ms-transition: -ms-transform 0.75s ease, opacity 0.75s ease;
    transition: transform 0.75s ease, opacity 0.75s ease;
    -moz-transition-delay: 3.5s;
    -webkit-transition-delay: 3.5s;
    -ms-transition-delay: 3.5s;
    transition-delay: 3.5s;
    -moz-transform: translateY(0);
    -webkit-transform: translateY(0);
    -ms-transform: translateY(0);
    transform: translateY(0);
    border: none;
    bottom: 0;
    color: inherit;
    font-size: 0.8em;
    height: 8.5em;
    left: 50%;
    letter-spacing: 0.225em;
    margin-left: -8.5em;
    opacity: 1;
    outline: 0;
    padding-left: 0.225em;
    position: absolute;
    text-align: center;
    text-transform: uppercase;
    width: 16em;
    z-index: 1;
}

#banner .more:after {
    /* background-image: url("../assets/arrow.png"); */
    background-position: center;
    background-repeat: no-repeat;
    background-size: contain;
    bottom: 4em;
    content: '';
    display: block;
    height: 1.5em;
    left: 50%;
    margin: 0 0 0 -0.75em;
    position: absolute;
    width: 1.5em;
}

#banner:after {
    pointer-events: none;
    -moz-transition: opacity 3s ease-in-out;
    -webkit-transition: opacity 3s ease-in-out;
    -ms-transition: opacity 3s ease-in-out;
    transition: opacity 3s ease-in-out;
    -moz-transition-delay: 1.25s;
    -webkit-transition-delay: 1.25s;
    -ms-transition-delay: 1.25s;
    transition-delay: 1.25s;
    content: '';
    background: #2e3842;
    display: block;
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    top: 0;
    opacity: 0;
}

body.is-preload #banner h2 {
  -moz-transform: none;
  -webkit-transform: none;
  -ms-transform: none;
  transform: none;
  opacity: 1;
}

  body.is-preload #banner h2:before, body.is-preload #banner h2:after {
    width: 100%;
  }

body.is-preload #banner .more {
  -moz-transform: none;
  -webkit-transform: none;
  -ms-transform: none;
  transform: none;
  opacity: 1;
}

body.is-preload #banner:after {
  opacity: 0;
}

@media screen and (max-width: 736px) {
    #banner {
        padding: 7em 3em 5em 3em;
        height: auto;
        min-height: 0;
    }
    #banner h2 {
        font-size: 1.25em;
    }
    #banner br {
        display: none;
    }
    #banner .more {
        display: none;
    }
}

body.is-preload #banner h2 {
    -moz-transform: scale(0.95);
    -webkit-transform: scale(0.95);
    -ms-transform: scale(0.95);
    transform: scale(0.95);
    opacity: 0;
}

body.is-preload #banner h2:before,
body.is-preload #banner h2:after {
    width: 0;
}

body.is-preload #banner .more {
    -moz-transform: translateY(8.5em);
    -webkit-transform: translateY(8.5em);
    -ms-transform: translateY(8.5em);
    transform: translateY(8.5em);
    opacity: 0;
}

body.is-preload #banner:after {
    opacity: 1;
}


/* CTA */

#cta .inner {
    display: -moz-flex;
    display: -webkit-flex;
    display: -ms-flex;
    display: flex;
    max-width: 45em;
}

#cta .inner header {
    -moz-order: 1;
    -webkit-order: 1;
    -ms-order: 1;
    order: 1;
    padding-right: 3em;
    width: 70%;
}

#cta .inner header p {
    color: inherit;
}

#cta .inner .actions {
    -moz-order: 2;
    -webkit-order: 2;
    -ms-order: 2;
    order: 2;
    width: 30%;
}

@media screen and (max-width: 980px) {
    #cta .inner {
        display: block;
        text-align: center;
    }
    #cta .inner header {
        padding-right: 0;
        width: 100%;
    }
    #cta .inner .actions {
        margin-left: auto;
        margin-right: auto;
        max-width: 20em;
        width: 100%;
    }
}

@media screen and (max-width: 736px) {
    #cta .inner .actions {
        max-width: none;
    }
}


/* Main */

#main>header {
    padding: 5em 0 5em 0;
    background-image: -moz-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: -webkit-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: -ms-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-attachment: fixed;
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
    text-align: center;
}

#main>header h2 {
    font-size: 3em;
    margin: 0 0 0.5em 0;
}

#main>header p {
    /* color: inherit; */
    letter-spacing: 0.225em;
    text-transform: uppercase;
    top: 0;
    font-size: 1.3em;
    padding: 10pt 0 0 0;
    margin: 0 auto;
}
#main>header p a {
    color: inherit;
}

@media screen and (max-width: 1680px) {
    #main>header {
        padding: 10em 0 8em 0;
    }
}

@media screen and (max-width: 1280px) {
    #main>header {
        padding: 8em 3em 6em 3em;
    }
}

@media screen and (max-width: 980px) {
    #main>header {
        padding: 10em 3em 8em 3em;
    }
}

@media screen and (max-width: 736px) {
    #main>header {
        padding: 5em 3em 3em 3em;
    }
    #main>header h2 {
        font-size: 1.25em;
        margin: 0 0 1em 0;
    }
}

body.is-mobile #main>header {
    background-attachment: scroll;
}
/* Landing */

body.landing #page-wrapper {
    background-image: -moz-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: -webkit-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: -ms-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-attachment: fixed;
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
    padding-top: 0;
}

body.landing #footer {
    background-color: rgba(29, 36, 42, 0.9);
}

body.is-mobile.landing #page-wrapper {
    background: none;
}

body.is-mobile.landing #banner,
body.is-mobile.landing .wrapper.style4 {
    background-image: -moz-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: -webkit-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: -ms-linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-image: linear-gradient(top, rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("../assets/bgimg.jpg");
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
}

body.is-mobile.landing #footer {
    background-color: #1d242a;
}

.ulbox {
    border: 2px solid white;
    float: left;
    text-align: center;
    width: 100%;
    margin-top: 15px;
    margin-bottom: 15px;
    background-color: #557571
}
.ulbox ul {
    list-style-type: none;
    float: left;
    text-align: center;
    margin-right: 15px;
    margin-left: 15px;
    font-size: 1.25em;
}
.ulbox li {
    color: #ffffff;
    float: left;
    text-align: center;
}
</style>