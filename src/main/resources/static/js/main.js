// 날짜 포맷 함수
function formatDate(date) {
    return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
}

// 특정 기간 전의 날짜를 계산하는 함수
function getDateFromNow(days, months, years) {
    var now = new Date();
    return new Date(now.getFullYear() - years, now.getMonth() - months, now.getDate() - days);
}

// 차트 데이터를 업데이트하기 위한 함수
function updateChartData(period) {
    var startDate, endDate = new Date();
    var labels = [];
    var oneDay = 24 * 60 * 60 * 1000; // 하루의 밀리초

    if (period === '1week') {
        startDate = getDateFromNow(7, 0, 0);
        for (var d = startDate; d <= endDate; d = new Date(d.getTime() + oneDay)) {
            labels.push(formatDate(d));
        }
    } else if (period === '6months') {
        startDate = getDateFromNow(0, 6, 0);
        for (var m = startDate; m <= endDate; m = new Date(m.getFullYear(), m.getMonth() + 1, m.getDate())) {
            labels.push(formatDate(m));
        }
    } else if (period === '1year') {
        startDate = getDateFromNow(0, 0, 1);
        for (var y = startDate; y <= endDate; y = new Date(y.getFullYear(), y.getMonth() + 1, y.getDate())) {
            labels.push(formatDate(y));
        }
    }

    return labels;
}

// 특정 그래픽카드에 따라 차트 업데이트
function updateChartWithVga() {
    var selectedVga = document.getElementById('vgaSelect').value;
    console.log("선택된 그래픽카드: " + selectedVga);
    updateChart('6months'); // 현재 선택된 기간에 따라 차트 업데이트
}

// 기간에 따라 차트 업데이트
function updateChart(period) {
    var newLabels = updateChartData(period);
    chart.data.labels = newLabels;
    chart.data.datasets[0].data = newLabels.map(() => Math.floor(Math.random() * 100));
    chart.update();
}

// 차트 초기화
var ctx = document.getElementById('graphicsCardChart').getContext('2d');
var chart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: updateChartData('6months'), // 기본값으로 6개월 데이터 사용
        datasets: [{
            label: '그래픽카드 가격',
            backgroundColor: 'rgba(0, 123, 255, 0.5)',
            borderColor: 'rgba(0, 123, 255, 1)',
            data: [] // 초기 데이터 설정 필요
        }]
    },
    options: {}
});

// 초기 차트 데이터 설정
updateChart('6months');