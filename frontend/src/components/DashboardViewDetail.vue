<template>

    <v-card outlined>
        <v-card-title>
            Dashboard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="RentStatus" v-model="item.rentStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PaymentStatus" v-model="item.paymentStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DashboardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dashboards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

