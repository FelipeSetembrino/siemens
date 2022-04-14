<template>
    <div>
        <NavBar/>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-10">
                    <router-view/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import NavBar from './layout/NavBar.vue'
export default {
    components: {
        NavBar,
    }
}
</script>