<template>

    <v-card outlined>
        <v-card-title>
            BikeCondition # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="RentCount" v-model="item.rentCount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="AvailableRent" v-model="item.availableRent" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'BikeConditionViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/bikeConditions/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

